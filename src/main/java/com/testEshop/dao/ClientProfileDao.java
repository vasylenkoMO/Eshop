package com.testEshop.dao;

import com.testEshop.model.entity.ClientProfile;

import java.util.List;

/**
 * Created by vastl271nko on 06.09.16.
 */
public interface ClientProfileDao {
    List<ClientProfile> findAll();

    ClientProfile findByType(String type);

    ClientProfile findById(int id);
}
