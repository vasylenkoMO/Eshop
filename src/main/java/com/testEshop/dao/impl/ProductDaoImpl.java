package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ProductDao;
import com.testEshop.model.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    public ProductDaoImpl() {

    }
}
