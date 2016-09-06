package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ClientDao;
import com.testEshop.model.entity.Category;
import com.testEshop.model.entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Repository(value = "clientDao")
public class ClientDaoImpl extends AbstractDao<Integer,Client> implements ClientDao {

    public ClientDaoImpl() {
    }
    static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);


    public Client findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Client client = (Client) crit.uniqueResult();
        if(client!=null){
            Hibernate.initialize(client.getClientProfiles());
        }
        return client;
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

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Client client = (Client) crit.uniqueResult();
        delete(client);
    }
}
