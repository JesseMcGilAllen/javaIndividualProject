package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;
import com.jessemcgilallen.lc.entity.Type;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TopicDao extends AbstractDao {
    private final Logger logger = Logger.getLogger(this.getClass());

    public TopicDao() {
        super(Topic.class);
    }

    @Override
    public List findByCriteria(Criteria criteria) {
        return super.findByCriteria(criteria);
    }

    public List<Topic> topicsUsingTopicCriteria(Type type, Language language) {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Topic> topics = null;
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Criteria criteria = getSession().createCriteria(Topic.class)
                    .createAlias("languages", "lang")
                    .add(Restrictions.eq("lang.id", language.getId()))
                    .add(Restrictions.eq("type.id", type.getId()));

            topics = criteria.list();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(exception);
        } finally {
            session.close();
        }

        return topics;
    }

    public List<Topic> topicsWithType(Type type) {
        Transaction transaction = null;
        List<Topic> topics = null;
        session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            Criteria criteria = getSession().createCriteria(Topic.class)
                    .add(Restrictions.eq("type.id", type.getId()));

            topics = criteria.list();

            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(exception);

        } finally {
            session.close();
        }

        return topics;
    }

}
