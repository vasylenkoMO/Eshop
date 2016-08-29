package com.testEshop.dao;

import com.testEshop.model.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Transactional
public abstract class AbstractDao <PK extends Serializable, T> {


    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        /*Type[] actualTypeArguments = ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.persistentClass =(Class<T>) actualTypeArguments[0];*/
        this.persistentClass = (Class<T>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void update(T entity) { getSession().merge(entity);}

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
