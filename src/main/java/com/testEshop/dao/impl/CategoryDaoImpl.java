package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.CategoryDao;
import com.testEshop.model.entity.Category;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

    public CategoryDaoImpl() {
    }

    @Override
    public List<Category> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Category>) criteria.list();
    }

    @Override
    public void save(Category object) {
        persist(object);
    }

    @Override
    public Category findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Category object) {
        delete(object);
    }
}
