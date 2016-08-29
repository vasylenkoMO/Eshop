package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SaleHistoryDao;
import com.testEshop.model.entity.Sale;
import com.testEshop.model.entity.SaleHistory;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "saleHistoryDao")
public class SaleHistoryDaoImpl extends AbstractDao<Integer, SaleHistory> implements SaleHistoryDao {

    public SaleHistoryDaoImpl() {
    }

    @Override
    public List<SaleHistory> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<SaleHistory>) criteria.list();
    }

    @Override
    public void save(SaleHistory object) {
        persist(object);
    }

    @Override
    public SaleHistory findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(SaleHistory object) {
        delete(object);
    }
}
