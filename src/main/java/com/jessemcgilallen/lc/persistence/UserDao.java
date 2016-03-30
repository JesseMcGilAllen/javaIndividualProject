package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * implements CRUD methods needed for implementation of
 * UserDao interface
 * @author jessemcgilallen
 * @version 1.0 Febraury 9th, 2016
 */
public class UserDao extends AbstractDao {

    public UserDao() {
        super(User.class);
    }

    public User findById(int id) {

        User user = (User)super.findById(id);

        return user;
    }

    public User findByUsername(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("username", username));
        User user = (User)super.findByCriteria(criteria).get(0);

        return user;
    }
}
