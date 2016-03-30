package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 3/28/16.
 */

public class LanguageDaoTest {

    private LanguageDao dao = new LanguageDao();

    @After
    public void tearDown() throws Exception {
        List<Language> languages = dao.findAll();

        for (Language language : languages) {
            dao.delete(language);

        }
    }

    private void addLanguagesForTesting() {

        dao.create(new Language("Ruby"));
        dao.create(new Language("Swift"));
        dao.create(new Language("Haskell"));
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
    public void testFindAll() throws Exception {

        addLanguagesForTesting();
        List<Language> languages = dao.findAll();

        assertTrue("Languages not received", languages.size() > 0);

    }

    @Test
    public void testFindById() throws Exception {
        Language python = new Language("python");
        dao.create(python);

        int pythonId = python.getId();

        python = dao.findById(pythonId);
        System.out.println("Python Id:" + pythonId);
        int findByIdPython = python.getId();

        assertTrue("Found Wrong Object", findByIdPython == pythonId);

        dao.delete(python);

    }

    @Test
    public void testFindByName() throws Exception {
        Language perl = new Language("Perl");
        dao.create(perl);

        String perlName = perl.getName();

        Language perlByName = dao.findByName(perl.getName());

        assertTrue("Found Wrong Object", perlName.equals(perlByName.getName()));

        dao.delete(perl);
    }

    @Test
    public void testUpdate() throws Exception {
        Language language = new Language("Java");

        dao.create(language);

        Language modifiedLanguage = dao.findById(language.getId());
        modifiedLanguage.setName("Swift");

        dao.update(modifiedLanguage);



        boolean sameNames = language.getName().equals(modifiedLanguage.getName());
        boolean sameIds = language.getId() == modifiedLanguage.getId();

        assertFalse("Names should be different", sameNames);
        assertTrue("Ids should be the same", sameIds);
    }

    @Test
    public void testDelete() throws Exception {
        addLanguagesForTesting();

        List<Language> languages = dao.findAll();
        int languagesCount = languages.size();

        Language languageToDelete = languages.get(0);
        dao.delete(languageToDelete);

        List<Language> updatedLanguages = dao.findAll();
       int updatedLanguagesCount = updatedLanguages.size();

        assertTrue("User not deleted", (languagesCount - 1) == updatedLanguagesCount);



    }
}