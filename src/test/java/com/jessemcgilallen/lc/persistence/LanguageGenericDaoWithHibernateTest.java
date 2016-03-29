package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.LanguageGenericDaoWithHibernate;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public class LanguageGenericDaoWithHibernateTest {

    private LanguageGenericDaoWithHibernate dao = new LanguageGenericDaoWithHibernate();


    private void addLanguagesForTestingFindAll() {

        dao.create(new Language("Ruby"));
        dao.create(new Language("Swift"));
        dao.create(new Language("Haskell"));
    }

    private void deleteLanguagesForTestingFindAll() {

        Language ruby = dao.findByName("Ruby");
        Language swift = dao.findByName("Swift");
        Language haskell = dao.findByName("Haskell");

        dao.delete(ruby);
        dao.delete(swift);
        dao.delete(haskell);

    }

    @Test
    public void testFindAll() throws Exception {

        addLanguagesForTestingFindAll();
        List<Language> languages = dao.findAll();

        assertTrue("Languages not received", languages.size() > 0);

        deleteLanguagesForTestingFindAll();

    }

    @Test
    public void testCreate() throws Exception {
        int languageCount = dao.findAll().size();
        int newLanguageCount;

        Language java = new Language("Java");
        dao.create(java);

        newLanguageCount = dao.findAll().size();
        assertTrue("Language wasn't added", newLanguageCount > languageCount);
    }

    @Test
    public void findById() throws Exception {
        Language java = new Language("Java");
        dao.create(java);

        int javaId = java.getId();

        System.out.println("java id:" + javaId);

        Language javaById = dao.findById(javaId);

        assertTrue("Found Wrong Object", java.getId() == javaById.getId());

        dao.delete(java);

    }

    @Test
    public void findByName() throws Exception {

    }
}