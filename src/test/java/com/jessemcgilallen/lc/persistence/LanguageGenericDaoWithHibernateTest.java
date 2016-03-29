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

        List<Language> languages = dao.findAll();

        for (Language language:languages) {
            dao.delete(language);
        }

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
}