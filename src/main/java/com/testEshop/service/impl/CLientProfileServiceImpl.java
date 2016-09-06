package com.testEshop.service.impl;

import com.testEshop.dao.ClientProfileDao;
import com.testEshop.model.entity.ClientProfile;
import com.testEshop.service.CLientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vastl271nko on 06.09.16.
 */
@Service("clientProfileService")
@Transactional
public class CLientProfileServiceImpl implements CLientProfileService {

    @Autowired
    ClientProfileDao clientProfileDao;


    @Override
    public ClientProfile findById(int id) {
        return clientProfileDao.findById(id);
    }

    @Override
    public ClientProfile findByType(String type) {
        return clientProfileDao.findByType(type);
    }

    @Override
    public List<ClientProfile> findAll() {
        return clientProfileDao.findAll();
    }
}
