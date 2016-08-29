package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ProductDao;
import com.testEshop.model.entity.Client;
import com.testEshop.model.entity.Product;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {
    public ProductDaoImpl() {

    }

    @Override
    public List<Product> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    @Override
    public void save(Product object) {
        persist(object);
    }

    @Override
    public Product findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Product object) {
        delete(object);
    }
}
