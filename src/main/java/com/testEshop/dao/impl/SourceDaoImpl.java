package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.SourceDao;
import com.testEshop.model.entity.Source;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "sourceDao")
public class SourceDaoImpl extends AbstractDao<Integer, Source> implements SourceDao {

    public SourceDaoImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Source> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Source>) criteria.list();
    }

    @Override
    public void save(Source object) {
        persist(object);
    }

    @Override
    public Source findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Source object) {
        delete(object);
    }

    @Override
    public Source findBySourceName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Source) criteria.uniqueResult();
    }
}
