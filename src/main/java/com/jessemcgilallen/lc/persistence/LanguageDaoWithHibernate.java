package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.LanguageDao;

import java.util.List;

/**
 * implements LanguageDao interface
 * @author jessemcgilallen
 * @version 1.0 3/27/16.
 */
public class LanguageDaoWithHibernate implements LanguageDao {

    @Override
    public int addLanguage(Language language) {
        return 0;
    }

    @Override
    public List<Language> getAllLanguages() {
        return null;
    }

    @Override
    public Language getLanguageWithId(int id) {
        return null;
    }

    @Override
    public void updateLanguage(Language language) {

    }

    @Override
    public void deleteLanguage(Language language) {

    }


}
