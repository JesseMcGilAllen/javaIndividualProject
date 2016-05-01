package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;
import com.jessemcgilallen.lc.persistence.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public class LanguageDao extends AbstractDao {

    public LanguageDao() {
        super(Language.class);
    }

    public Language findById(int id) {

       Language language = (Language)super.findById(id);

        return language;
    }

    public Language findByName(String name) {

        Language language = (Language)super.findByName(name);

        return language;
    }
}
