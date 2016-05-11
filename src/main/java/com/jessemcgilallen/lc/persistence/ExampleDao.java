package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Example;
import com.jessemcgilallen.lc.entity.Topic;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by jessemcgilallen on 4/30/16.
 */
public class ExampleDao extends AbstractDao {
    private final Logger logger = Logger.getLogger(this.getClass());

    public ExampleDao() {
        super(Example.class);
    }

    public List<Example> findExamplesForTopic(Topic topic) {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Example> examples = null;

        try {
            transaction = session.beginTransaction();

            Criteria criteria = getSession().createCriteria(Example.class)
                    .add(Restrictions.eq("topic", topic));

            examples = findByCriteria(criteria);

            transaction.commit();
        } catch (HibernateException hibernateException) {
            if (transaction != null) {
                transaction.rollback();
            }

            logger.error(hibernateException);
        } finally {
            session.close();
        }

        return examples;
    }
}
