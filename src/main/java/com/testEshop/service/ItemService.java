package com.testEshop.service;

import com.testEshop.model.Model;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
public interface ItemService<T extends Model> {
    public List<T> getAll();

    public T getById(Long id);

    public void add(T model);

    public void update(T model);

    public void remove(T model);
}
