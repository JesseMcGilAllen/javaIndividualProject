package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Type;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TypesDaoTest {

    private TypesDao typesDao = new TypesDao();

    @Test
    public void testFindByName() throws Exception {
        Type algorithm = typesDao.findByName("algorithm");

        assertTrue("Wrong type returned", algorithm != null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByWrongName() throws Exception {
        Type wrongType = typesDao.findByName("language");
        fail("Expect Index Out of Bounds Exception");

    }

    @Test
    public void testFindAllTypes() throws Exception {
        List<Type> types = typesDao.findAll();

        assertTrue("Wrong number of types returned", types.size() == 5);
    }

}