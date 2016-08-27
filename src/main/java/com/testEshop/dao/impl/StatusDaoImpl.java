package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.StatusDao;
import com.testEshop.model.entity.Status;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "statusDao")
public class StatusDaoImpl extends AbstractDao<Status> implements StatusDao {

    public StatusDaoImpl() {

    }
}
