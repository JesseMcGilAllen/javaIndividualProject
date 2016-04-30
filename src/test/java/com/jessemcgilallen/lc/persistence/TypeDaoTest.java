package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Type;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TypeDaoTest {

    private TypeDao typeDao = new TypeDao();

    @Test
    public void testFindByName() throws Exception {
        Type algorithm = typeDao.findByName("algorithm");

        assertTrue("Wrong type returned", algorithm != null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByWrongName() throws Exception {
        Type wrongType = typeDao.findByName("language");
        fail("Expect Index Out of Bounds Exception");

    }

    @Test
    public void testFindAllTypes() throws Exception {
        List<Type> types = typeDao.findAll();

        assertTrue("Wrong number of types returned", types.size() == 5);
    }

}