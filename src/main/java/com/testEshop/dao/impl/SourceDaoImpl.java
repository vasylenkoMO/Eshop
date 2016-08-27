package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SourceDao;
import com.testEshop.model.entity.Source;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "sourceDao")
public class SourceDaoImpl extends AbstractDao<Source> implements SourceDao {

    public SourceDaoImpl() {
    }
}
