package com.testEshop.service.impl;

import com.testEshop.dao.ClientDao;
import com.testEshop.model.entity.Client;
import com.testEshop.service.ClientService;
import com.testEshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Service(value = "clientService")
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public void save(Client object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        clientDao.save(object);
    }

    @Override
    public Client findById(int id) {
        return clientDao.findById(id);
    }

    @Override
    public void deleteItem(Client object) {
        clientDao.deleteItem(object);
    }


    @Override
    public void sendClientRegisterConfirmation(Client client) {
        mailService.sendEmail(client);
    }

    @Override
    public Client findBySSO(String sso) {
        Client user = clientDao.findBySSO(sso);
        return user;
    }

    @Override
    public void deleteUserBySSO(String sso) {
        clientDao.deleteBySSO(sso);
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        Client client = findBySSO(sso);
        return ( client == null || ((id != null) && (client.getId() == id)));
    }
}
