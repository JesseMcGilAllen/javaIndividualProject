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
    //private Session session;
    private Class<T> typeParameterClass;

    public AbstractDao() {
    }

    public AbstractDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private Class<T> getTypeParameterClass() {
        return typeParameterClass;
    }

    public List<T> findAll() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<T> list = new ArrayList<T>();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(getTypeParameterClass());
            list = criteria.list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } finally {
            session.close();
        }

        return list;
    }

    public T findById(int id) {
        Session session = null;
        T instance = null;

        try {
           //session = SessionFactoryProvider.getSessionFactory().openSession();
            session = openSession();
            instance = (T) session.load(getTypeParameterClass(), id);

        } catch (Exception exception) {
            logger.error(exception);
        }
//        Criteria criteria = session.createCriteria(getTypeParameterClass())
//
//        List<T> results = findByCriteria(criteria);
//
//         T result = results.get(0);

        return instance;
    }

    public T findByName(String name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(getTypeParameterClass())
                .add(Restrictions.eq("name", name));

        List<T> results = findByCriteria(criteria);

        T instance = results.get(0);

        logger.setLevel(Level.DEBUG);
        logger.debug("Instance: " + instance);

        return instance;
    }

    public List<T> findByRestrictionsMap(Map<String, Object> restrictions) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(getTypeParameterClass());
        restrictions.forEach((key, value) ->
                criteria.add(Restrictions.eq(key, value)));

        List<T> results = findByCriteria(criteria);
        logger.setLevel(Level.DEBUG);
        logger.debug("Concepts: " + results);

        return results;
    }

    public List<T> findByCriteria(Criteria criteria) {
       Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<T> list = new ArrayList<>();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            list = criteria.list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } finally {
            session.close();
        }

        return list;
    }

    public int create(T entity) {
       Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer id = null;

        try {
            transaction = session.beginTransaction();
            id = (Integer) session.save(entity);
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
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
        Session session = null;
        // session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            session = openSession();
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

    public Session openSession() {
        Session session = SessionFactoryProvider.getSessionFactory().getCurrentSession();

        if (session == null) {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        }

        return session;

    }

    public void closeSession(Session session) {
        session.close();
    }

}
