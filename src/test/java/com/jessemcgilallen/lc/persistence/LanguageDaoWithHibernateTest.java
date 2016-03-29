package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.LanguageDaoWithHibernate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public class LanguageDaoWithHibernateTest {

    private LanguageDaoWithHibernate dao = new LanguageDaoWithHibernate();


    @Test
    public void addLanguage() throws Exception {
        int languageCount = dao.getAllLanguages().size();
        int newLanguageCount = 0;

        Language java = new Language("Java");

        dao.addLanguage(java);
        newLanguageCount = dao.getAllLanguages().size();

        assertTrue("Language wasn't added", newLanguageCount > languageCount);
        dao.deleteLanguage(java);
    }

    @Test
    public void getAllLanguages() throws Exception {

    }

    @Test
    public void getLanguageWithId() throws Exception {

    }

    @Test
    public void updateLanguage() throws Exception {

    }

    @Test
    public void deleteLanguage() throws Exception {

    }
}