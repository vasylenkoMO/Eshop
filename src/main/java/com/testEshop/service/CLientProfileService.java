package com.testEshop.service;

import com.testEshop.model.entity.ClientProfile;

import java.util.List;

/**
 * Created by vastl271nko on 06.09.16.
 */
public interface CLientProfileService {

    ClientProfile findById(int id);

    ClientProfile findByType(String type);

    List<ClientProfile> findAll();
}
