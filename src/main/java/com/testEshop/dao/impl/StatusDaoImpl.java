package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.StatusDao;
import com.testEshop.model.entity.Source;
import com.testEshop.model.entity.Status;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "statusDao")
public class StatusDaoImpl extends AbstractDao<Integer, Status> implements StatusDao {

    public StatusDaoImpl() {

    }

    @Override
    public List<Status> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Status>) criteria.list();
    }

    @Override
    public void save(Status object) {
        persist(object);
    }

    @Override
    public Status findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Status object) {
        delete(object);
    }
}
