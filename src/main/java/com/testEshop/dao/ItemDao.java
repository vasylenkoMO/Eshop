package com.testEshop.dao;

import com.testEshop.model.Model;

import java.util.List;

/**
 * Created by vastl271nko on 15.08.16.
 */
public interface ItemDao<T> {

    public List<T> findAll();

    public void save(T object);

    public T findById(int id);

    public void deleteItem(T object);
}
