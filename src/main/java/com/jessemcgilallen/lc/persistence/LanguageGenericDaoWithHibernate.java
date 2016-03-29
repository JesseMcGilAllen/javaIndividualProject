package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Language;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public class LanguageGenericDaoWithHibernate extends GenericDaoWithHibernate {

    public LanguageGenericDaoWithHibernate() {
        super(Language.class);
    }




}
