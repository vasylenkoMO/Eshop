package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SaleHistoryDao;
import com.testEshop.model.entity.SaleHistory;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "saleHistoryDao")
public class SaleHistoryDaoImpl extends AbstractDao<SaleHistory> implements SaleHistoryDao {

    public SaleHistoryDaoImpl() {
    }
}
