package com.testEshop.service.impl;

import com.testEshop.dao.SourceDao;
import com.testEshop.model.entity.Source;
import com.testEshop.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyEditorSupport;
import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Service(value = "sourceService")
@Transactional
public class SourceServiceImpl extends PropertyEditorSupport implements SourceService {

    @Autowired
    SourceDao sourceDao;


    @Override
    public List<Source> findAll() {
        return sourceDao.findAll();
    }

    @Override
    public void save(Source object) {
        sourceDao.save(object);
    }

    @Override
    public Source findById(int id) {
        return sourceDao.findById(id);
    }

    @Override
    public void deleteItem(Source object) {
        sourceDao.deleteItem(object);
    }

    @Override
    public Source findBySourceName(String name) {
        return sourceDao.findBySourceName(name);
    }
}
