package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jessemcgilallen
 * @version 1.0 on 3/28/16.
 */
public abstract class GenericDaoWithHibernate<T> {

    private final Logger logger = Logger.getLogger(this.getClass());

    private Class<T> typeParameterClass;

    public GenericDaoWithHibernate() {
    }

    public GenericDaoWithHibernate(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private Class<T> getTypeParameterClass() {
        return typeParameterClass;
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Language.class)
                .add(Restrictions.eq("id", id));
        List<T> results = findByCriteria(criteria);

        session.close();

        return results.get(0);
    }

    public List<T> findByCriteria(Criteria criteria) {
        List<T> list = new ArrayList<T>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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

    public void delete(T entity) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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


}
