package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Type;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TypeDao extends AbstractDao {

    public TypeDao() {
        super(Type.class);

    }

    public Type findById(int id) {

        Type type = (Type)super.findById(id);

        return type;
    }

    public Type findByName(String name) {

        Type type = (Type)super.findByName(name);

        return type;
    }


}
