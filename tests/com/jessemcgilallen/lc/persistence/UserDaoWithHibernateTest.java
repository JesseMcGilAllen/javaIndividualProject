package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 2/9/16.
 */
public class UserDaoWithHibernateTest {

   private UserDaoWithHibernate dao = new UserDaoWithHibernate();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testAddUser() throws Exception {
        int userCount = dao.getAllUsers().size();
        int newUserCount = 0;

        User user = new User();
        user.setUsername("Bob");
        user.setEmailAddress("bob@example.com");
        user.setPassword("password");

        dao.addUser(user);
        newUserCount = dao.getAllUsers().size();

        assertTrue(newUserCount > userCount);
    }

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }
}