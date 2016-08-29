package com.testEshop.service.impl;

import com.testEshop.dao.ClientDao;
import com.testEshop.dao.impl.ClientDaoImpl;
import com.testEshop.model.entity.Client;
import com.testEshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public void save(Client object) {
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
}
