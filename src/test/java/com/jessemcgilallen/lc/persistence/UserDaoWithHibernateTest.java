package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;
import com.jessemcgilallen.lc.persistence.UserDaoWithHibernate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 2/9/16.
 */
public class UserDaoWithHibernateTest {

   private UserDaoWithHibernate dao = new UserDaoWithHibernate();
    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUsername("Adam");
        user.setEmailAddress("adam@example.com");
        user.setPassword("password");

        User userTwo = new User();
        userTwo.setUsername("Beth");
        userTwo.setEmailAddress("beth@example.com");
        userTwo.setPassword("password");

        User userThree = new User();
        userThree.setUsername("Dana");
        userThree.setEmailAddress("dana@example.com");
        userThree.setPassword("password");

        dao.addUser(user);
        dao.addUser(userTwo);
        dao.addUser(userThree);
    }

    @After
    public void tearDown() throws Exception {
        List<User> users = dao.getAllUsers();

        for (User user : users) {
            dao.deleteUser(user);

        }
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

        assertTrue("User wasn't added", newUserCount > userCount);
        dao.deleteUser(user);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();

        assertTrue("Users not received " + users.size(), users.size() > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {
        List<User> users = dao.getAllUsers();
        User userToModify = users.get(0);
        String name = userToModify.getUsername();

        userToModify.setUsername("Zeke");
        dao.updateUser(userToModify);

        User modifiedUser = dao.getAllUsers().get(0);

        boolean sameNames = modifiedUser.getUsername().equals(name);
        boolean sameIds = modifiedUser.getId() == userToModify.getId();

        assertFalse("Names are supposed to be different", sameNames);
        assertTrue("IDs should be the same", sameIds);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNullUser() throws Exception {
       User user = null;

        dao.updateUser(user);
        fail("Expect Illegal Argument Exception");

    }

    @Test
    public void testDeleteUser() throws Exception {
        List<User> users = dao.getAllUsers();
        int userCount = users.size();
        User userToDelete = users.get(0);
        dao.deleteUser(userToDelete);
        int newUserCount = dao.getAllUsers().size();

        assertTrue("User was not deleted", userCount - 1 == newUserCount);
    }

    @Test(expected = AssertionError.class)
    public void testDeleteNullUser() throws Exception {
        User userToDelete = new User();
        dao.deleteUser(userToDelete);

        fail("Expected Assertion Error");
    }
}