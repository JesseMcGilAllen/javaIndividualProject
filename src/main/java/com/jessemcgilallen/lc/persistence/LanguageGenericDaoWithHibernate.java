package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public class LanguageGenericDaoWithHibernate extends GenericDaoWithHibernate {

    public LanguageGenericDaoWithHibernate() {
        super(Language.class);
    }

    public Language findById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Language.class)
                .add(Restrictions.eq("id", id));
       Language language = (Language)super.findByCriteria(criteria).get(0);

        session.close();

        return language;
    }

    public Language findByName(String name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Language.class)
                .add(Restrictions.eq("name", name));
        Language language = (Language)super.findByCriteria(criteria).get(0);

        session.close();

        return language;
    }






}
