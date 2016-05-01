package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jessemcgilallen
 * @version 1.0 on 3/28/16.
 */
public abstract class AbstractDao<T> {

    private final Logger logger = Logger.getLogger(this.getClass());
    private Session session;
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

        }

        return list;
    }

    public T findById(int id) {
        Criteria criteria = session.createCriteria(getTypeParameterClass())
                .add(Restrictions.eq("id", id));
        List<T> results = findByCriteria(criteria);

         T result = results.get(0);

        return result;
    }

    public T findByName(String name) {
        Criteria criteria = session.createCriteria(getTypeParameterClass())
                .add(Restrictions.eq("name", name));
        List<T> results = findByCriteria(criteria);

        T instance = results.get(0);

        logger.setLevel(Level.DEBUG);
        logger.debug("Instance: " + instance);

        return instance;
    }

    public List<T> findByCriteria(Criteria criteria) {
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

        }

        return list;
    }

    public int create(T entity) {
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
        }

        return id;
    }

    public void update(T entity) {
        session = SessionFactoryProvider.getSessionFactory().getCurrentSession();
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
        }
    }

    public void delete(T entity) {
        session = SessionFactoryProvider.getSessionFactory().getCurrentSession();
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

        }
    }

    public void openSession() {
        session = SessionFactoryProvider.getSessionFactory().getCurrentSession();
        if (session != null) {
            session.close();
        }

        session = SessionFactoryProvider.getSessionFactory().openSession();
    }

    public void closeSession() {
        session = SessionFactoryProvider.getSessionFactory().getCurrentSession();
        session.close();
    }

}
