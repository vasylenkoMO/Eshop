package com.testEshop.dao;

import com.testEshop.model.entity.Client;

/**
 * Created by vastl271nko on 16.08.16.
 */
public interface ClientDao extends ItemDao<Client> {

    public  Client getByUsername(String username);

}
