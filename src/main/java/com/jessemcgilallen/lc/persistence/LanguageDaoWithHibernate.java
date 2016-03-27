package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;

import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * implements LanguageDao interface
 * @author jessemcgilallen
 * @version 1.0 3/27/16.
 */
public class LanguageDaoWithHibernate implements LanguageDao {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public int addLanguage(Language language) {
        return 0;
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
        return null;
    }

    @Override
    public void updateLanguage(Language language) {

    }

    @Override
    public void deleteLanguage(Language language) {

    }


}
