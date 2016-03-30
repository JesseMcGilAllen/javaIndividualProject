package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.User;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 2/9/16.
 */
public class UserDaoTest {

   private UserDao dao = new UserDao();
    private final Logger logger = Logger.getLogger(this.getClass());
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

        dao.create(user);
        dao.create(userTwo);
        dao.create(userThree);
    }

    @After
    public void tearDown() throws Exception {
        List<User> users = dao.findAll();

        for (User user : users) {
            dao.delete(user);

        }
    }


    @Test
    public void testAddUser() throws Exception {
        int userCount = dao.findAll().size();
        int newUserCount;

        User user = new User();
        user.setUsername("Bob");
        user.setEmailAddress("bob@example.com");
        user.setPassword("password");

        dao.create(user);
        newUserCount = dao.findAll().size();

        assertTrue("User wasn't added", newUserCount > userCount);
        dao.delete(user);
    }

    @Test
    public void testFindById() throws Exception {
        User user = (User)dao.findAll().get(0);

        User savedUser = dao.findById(user.getId());

        int  savedUserId = savedUser.getId();

        assertTrue("Found Wrong User", user.getId() == savedUserId);
    }

    @Test
    public void testFindByUsername() throws Exception {
        User user = (User)dao.findAll().get(0);

        String username = user.getUsername();

        user = dao.findByUsername(username);
        String  savedUsername = user.getUsername();

        assertTrue("Found Wrong User", username.equals(savedUsername));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = dao.findAll();

        assertTrue("Users not received " + users.size(), users.size() > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {
        List<User> users = dao.findAll();
        User userToModify = users.get(0);
        String name = userToModify.getUsername();

        userToModify.setUsername("Zeke");
        dao.update(userToModify);

        User modifiedUser = (User) dao.findAll().get(0);

        boolean sameNames = modifiedUser.getUsername().equals(name);
        boolean sameIds = modifiedUser.getId() == userToModify.getId();

        assertFalse("Names are supposed to be different", sameNames);
        assertTrue("IDs should be the same", sameIds);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNullUser() throws Exception {
       User user = null;

        dao.update(user);
        fail("Expect Illegal Argument Exception");

    }

    @Test
    public void testDeleteUser() throws Exception {
        List<User> users = dao.findAll();
        int userCount = users.size();
        User userToDelete = users.get(0);
        dao.delete(userToDelete);
        int newUserCount = dao.findAll().size();

        assertTrue("User was not deleted", userCount - 1 == newUserCount);
    }

    @Test(expected = AssertionError.class)
    public void testDeleteNullUser() throws Exception {
        User userToDelete = new User();
        dao.delete(userToDelete);

        fail("Expected Assertion Error");
    }
}