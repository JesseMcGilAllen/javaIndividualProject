package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;


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
}
