package org.academiadecodigo.bootcamp.persistence.hibernate;


import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by codecadet on 23/03/17.
 */
public class HibernateTransactionManager implements TransactionManager{

    HibernateSessionManager hibernateSessionManager;

    public HibernateTransactionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }

    @Override
    public void beginTransaction() {

        hibernateSessionManager.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        hibernateSessionManager.commitTransaction();
    }

    @Override
    public void rollBack() {
        hibernateSessionManager.roolBackTransaction();
    }
}
