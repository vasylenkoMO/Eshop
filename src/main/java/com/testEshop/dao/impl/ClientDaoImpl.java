package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ClientDao;
import com.testEshop.model.entity.Category;
import com.testEshop.model.entity.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "clientDao")
public class ClientDaoImpl extends AbstractDao<Integer,Client> implements ClientDao {

    public ClientDaoImpl() {
    }

    @Override
    public Client getByUsername(String username) {
        Criteria criteria = getSession().createCriteria(Client.class);

        criteria.add(Restrictions.eq("username", username));

        return (Client)criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Client>) criteria.list();
    }

    @Override
    public void save(Client object) {
        persist(object);
    }

    @Override
    public Client findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteItem(Client object) {
        delete(object);
    }
}
