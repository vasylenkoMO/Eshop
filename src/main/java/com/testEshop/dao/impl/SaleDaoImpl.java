package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SaleDao;
import com.testEshop.model.entity.Product;
import com.testEshop.model.entity.Sale;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

    public SaleDaoImpl() {
    }

    @Override
    public List<Sale> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Sale>) criteria.list();
    }

    @Override
    public void save(Sale object) {
        persist(object);
    }

    @Override
    public Sale findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Sale object) {
        delete(object);
    }
}
