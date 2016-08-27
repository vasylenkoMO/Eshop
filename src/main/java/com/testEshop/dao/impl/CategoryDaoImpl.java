package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.CategoryDao;
import com.testEshop.model.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "categoryDao")
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    public CategoryDaoImpl() {
    }
}
