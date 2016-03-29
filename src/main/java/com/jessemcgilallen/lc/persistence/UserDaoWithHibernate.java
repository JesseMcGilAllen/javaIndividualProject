package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;


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
public class UserDaoWithHibernate extends GenericDaoWithHibernate {

    public UserDaoWithHibernate() {
        super(User.class);
    }
}
