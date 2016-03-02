package main.java.com.jessemcgilallen.lc.persistence;

import main.java.com.jessemcgilallen.lc.entity.User;


import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * implements CRUD methods needed for implementation of
 * UserDao interface
 * @author jessemcgilallen
 * @version 1.0 Febraury 9th, 2016
 */
public class UserDaoWithHibernate implements UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * @param user to be added
     * @return userID
     */
    @Override
    public int addUser(User user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userId = null;

        try {

            transaction = session.beginTransaction();
            userId = (Integer) session.save(user);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            log.error(exception);

        } finally {
            session.close();

        }

        return userId;
    }



    /**
     * @return users
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            users = session.createQuery("from User").list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            log.error(exception);

        } finally {
            session.close();

        }

        return users;

    }

    /**
     * @param user to be updated
     */
    @Override
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            log.error(exception);

        } finally {
            session.close();

        }
    }

    /**
     * @param user to be deleted
     */
    @Override
    public void deleteUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            log.error(exception);

        } finally {
            session.close();

        }
    }
}
