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

    private void addLanguagesForTestingFindAll() {

        dao.create(new Language("Ruby"));
        dao.create(new Language("Swift"));
        dao.create(new Language("Haskell"));
    }

    @Test
    public void testFindAll() throws Exception {

        addLanguagesForTestingFindAll();
        List<Language> languages = dao.findAll();

        assertTrue("Languages not received", languages.size() > 0);

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
        Language python = new Language("python");
        dao.create(python);

        int pythonId = python.getId();

        python = dao.findById(pythonId);
        int findByIdPython = python.getId();

        assertTrue("Found Wrong Object", findByIdPython == pythonId);

        dao.delete(python);

    }

    @Test
    public void findByName() throws Exception {
        Language perl = new Language("Perl");
        dao.create(perl);

        String perlName = perl.getName();

        Language perlByName = dao.findByName(perl.getName());

        assertTrue("Found Wrong Object", perlName.equals(perlByName.getName()));

        dao.delete(perl);
    }
}