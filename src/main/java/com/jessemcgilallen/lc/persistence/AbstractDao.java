package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jessemcgilallen
 * @version 1.0 on 3/28/16.
 */
public abstract class AbstractDao<T> {

    private final Logger logger = Logger.getLogger(this.getClass());
    protected Session session;
    private Class<T> typeParameterClass;

    public AbstractDao() {
    }

    public AbstractDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private Class<T> getTypeParameterClass() {
        return typeParameterClass;
    }

    protected Session getSession() {
        if (session == null) {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        }

        return session;
    }

    public List<T> findAll() {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        List<T> list = new ArrayList<T>();
        Transaction transaction = null;

        try {
            session.beginTransaction();
            Criteria criteria = getSession().createCriteria(getTypeParameterClass());
            list = criteria.list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        }

        return list;
    }

    public T findById(int id) {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        T instance = null;

        try {
            transaction = session.beginTransaction();
            instance = (T) session.load(getTypeParameterClass(), id);
            transaction.commit();

        } catch (Exception exception) {
            logger.error(exception);
        } finally {
            session.close();
        }

        return instance;
    }

    public T findByName(String name) {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        T instance = null;

        try {
            transaction = session.beginTransaction();

            Criteria criteria = getSession().createCriteria(getTypeParameterClass())
                    .add(Restrictions.eq("name", name));

            List<T> results = findByCriteria(criteria);

            instance = results.get(0);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(hibernateException);
        } finally {
            session.close();
        }

        logger.setLevel(Level.DEBUG);
        logger.debug("Instance: " + instance);

        return instance;
    }

    public List<T> findByCriteria(Criteria criteria) {
        if (!session.isOpen()) {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        }
      
        List<T> list = new ArrayList<>();
        Transaction transaction = null;

        try {

            if (session.getTransaction() != null) {
                transaction = session.getTransaction();
            } else {
                transaction = session.beginTransaction();
            }
            list = criteria.list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);
        }

        return list;
    }

    public int create(T entity) {
        logger.warn("InCreate");
        session = SessionFactoryProvider.getSessionFactory().openSession();
       // getSession().SessionFactoryProvider.getSessionFactory().openSession();
//        if (session.isConnected()) {
//            logger.warn("connected");
//           // session = SessionFactoryProvider.getSessionFactory().getCurrentSession();
//        } else {
//            logger.warn("closed");
//
//        }

        logger.warn("Past session open");
        Transaction transaction = null;
        Integer id = null;

        try {
            transaction = session.beginTransaction();
            id = (Integer) session.save(entity);
            logger.warn("Saved: " + id);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } catch (NullPointerException nullPointerException) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(nullPointerException);
        } finally {
            session.close();
        }

        return id;
    }

    public void update(T entity) {
        if (!session.isOpen()) {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        }

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);
        } finally {
            session.close();
        }
    }

    public void delete(T entity) {
        if (!session.isOpen()) {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        }

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } finally {
            session.close();
        }
    }

    public void closeSession() {
        session.close();
    }

}
