package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ClientDao;
import com.testEshop.model.entity.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "clientDao")
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

    public ClientDaoImpl() {
    }

    @Override
    public Client getByUsername(String username) {
        Criteria criteria = getSession().createCriteria(Client.class);

        criteria.add(Restrictions.eq("username", username));

        return (Client)criteria.uniqueResult();
    }
}
