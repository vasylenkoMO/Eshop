package com.testEshop.dao;

import com.testEshop.model.entity.Client;

/**
 * Created by vastl271nko on 16.08.16.
 */
public interface ClientDao extends ItemDao<Client> {

    Client findBySSO(String sso);

    void deleteBySSO(String sso);

}
