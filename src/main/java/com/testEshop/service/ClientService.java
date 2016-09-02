package com.testEshop.service;

import com.testEshop.model.entity.Client;

/**
 * Created by vastl271nko on 27.08.16.
 */
public interface ClientService extends ItemService<Client> {

    public void  sendClientRegisterConfirmation(Client client);
}
