package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;

import java.util.List;

/**
 * Declares methods needed for Language DAO objects
 * @author jessemcgilallen
 * @version 1.0 3/27/16.
 */
public interface LanguageDao {

    /**
     * @return all languages
     */
    public List<Language> getAllLanguages();

    /**
     * @param language to be updated
     */
    public void updateLanguage(Language language);

    /**
     * @param language to be deleted
     */
    public void deleteLanguage(Language language);

    /**
     * @param language to be added
     * @return language id if successful
     */
    public int addLanguage(Language language);

    /**
     * @param id for a language
     * @return language for the id param
     */
    public Language getLanguageWithId(int id);
}
