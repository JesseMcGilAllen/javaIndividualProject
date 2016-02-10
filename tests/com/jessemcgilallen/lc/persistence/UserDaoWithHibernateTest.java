package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 2/9/16.
 */
public class UserDaoWithHibernateTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testAddUser() throws Exception {
        UserDaoWithHibernate dao = new UserDaoWithHibernate();
        int insertedUserId = 0;

        User user = new User();
        user.setUsername("Bob");
        user.setEmailAddress("bob@example.com");
        user.setPassword("password");
        user.setId(0);

        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);
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