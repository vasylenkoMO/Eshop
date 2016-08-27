package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SaleDao;
import com.testEshop.model.entity.Sale;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "saleDao")
public class SaleDaoImpl extends AbstractDao<Sale> implements SaleDao {

    public SaleDaoImpl() {
    }
}
