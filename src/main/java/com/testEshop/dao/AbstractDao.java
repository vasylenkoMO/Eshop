package com.testEshop.dao;

import com.testEshop.model.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
public abstract class AbstractDao <T extends Model> {
    private final Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(this.persistentClass);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);


        return criteria.list();
    }

    public T getById(Long id) {
        Criteria criteria = getSession().createCriteria(this.persistentClass);
        criteria.add(Restrictions.eq("id", id));
        return (T)criteria.uniqueResult();
    }

    public void add(T model) {
        getSession().save(model);
    }

    public void update(T model) {
        getSession().merge(model);
    }

    public void remove(T model) {
        getSession().delete(model);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
