package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.entity.Topic;
import com.jessemcgilallen.lc.entity.Type;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TopicDao extends AbstractDao {

    public TopicDao() {
        super(Topic.class);
    }

    @Override
    public List findByCriteria(Criteria criteria) {
        return super.findByCriteria(criteria);
    }

    public List<Topic> topicsUsingTopicCriteria(Type type, Language language) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Topic.class)
                .createAlias("languages", "lang")
                    .add(Restrictions.eq("lang.id", language.getId()))
                .add(Restrictions.eq("type.id", type.getId()));

        List<Topic> topics = criteria.list();

        session.close();

        return topics;
    }

}
