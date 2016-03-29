package com.jessemcgilallen.lc.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jessemcgilallen on 3/28/16.
 */
public interface GenericDao<T extends Serializable> {


    public T findById(int id);

    public void update(T entity);

    public void delete(T entity);

    public int create(T entity);
}
