package org.academiadecodigo.bootcamp.persistence.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by codecadet on 20/03/17.
 */
public class HibernateSessionManager {

    private SessionFactory sessionFactory;

    public HibernateSessionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session beginTransaction(){
        getSession().getTransaction().begin();
        return getSession();
    }

    public void commitTransaction(){
        getSession().getTransaction().commit();
    }

    public void roolBackTransaction(){
        getSession().getTransaction().rollback();
    }

    public void close() {
        sessionFactory.close();
    }




}
