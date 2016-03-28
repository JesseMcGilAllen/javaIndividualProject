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
import java.util.Optional;

/**
 * implements LanguageDao interface
 * @author jessemcgilallen
 * @version 1.0 3/27/16.
 */
public class LanguageDaoWithHibernate implements LanguageDao {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public int addLanguage(Language language) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer languageId = null;

        try {
            transaction = session.beginTransaction();
            languageId = (Integer) session.save(language);
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

        return languageId;
    }

    @Override
    public List<Language> getAllLanguages() {
        List<Language> languages = new ArrayList<Language>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Language.class);
            languages = criteria.list();

        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } finally {
            session.close();

        }

        return languages;
    }

    @Override
    public Language getLanguageWithId(int id) {
        Language language = new Language();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Language.class)
                    .add(Restrictions.eq("languageId", id));
            language = (Language)criteria.list().get(0);


        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(exception);

        } finally {
            session.close();

        }
        return language;
    }

    @Override
    public void updateLanguage(Language language) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(language);
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

    @Override
    public void deleteLanguage(Language language) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(language);
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
