package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;
import org.apache.log4j.Logger;
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

    private final Logger logger = Logger.getLogger(this.getClass());

    public UserDao() {
        super(User.class);
    }

}
