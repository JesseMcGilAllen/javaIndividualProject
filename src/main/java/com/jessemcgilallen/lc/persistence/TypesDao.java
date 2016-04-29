package com.jessemcgilallen.lc.persistence;

import com.jessemcgilallen.lc.entity.Type;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class TypesDao extends AbstractDao {

    public TypesDao() {
        super(Type.class);
    }

    public Type findById(int id) {

        Type type = (Type) super.findById(id);

        return type;
    }

    public Type findByName(String name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Type.class)
                .add(Restrictions.eq("name", name));
        Type type = (Type) super.findByCriteria(criteria).get(0);

        return type;
    }


}
