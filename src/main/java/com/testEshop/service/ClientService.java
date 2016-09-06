package com.testEshop.service;

import com.testEshop.model.entity.Client;

/**
 * Created by vastl271nko on 27.08.16.
 */
public interface ClientService extends ItemService<Client> {

    void  sendClientRegisterConfirmation(Client client);

    Client findBySSO(String sso);

    void deleteUserBySSO(String sso);

    boolean isUserSSOUnique(Integer id, String sso);


}
