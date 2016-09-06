package com.testEshop.dao.impl;

import com.testEshop.dao.AbstractDao;
import com.testEshop.dao.ClientProfileDao;
import com.testEshop.model.entity.ClientProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vastl271nko on 06.09.16.
 */
@Repository("clientProfileDao")
public class ClientProfileDaoImpl extends AbstractDao<Integer, ClientProfile> implements ClientProfileDao {

    public ClientProfile findById(int id) {
        return getByKey(id);
    }

    public ClientProfile findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (ClientProfile) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<ClientProfile> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<ClientProfile>)crit.list();
    }

}
