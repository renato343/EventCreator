package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.dao.InterfaceDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Renato on 24/03/17.
 */
public abstract class AbstractDao<T> implements InterfaceDao<T> {

    HibernateSessionManager hibernateSessionManager;
    Class<T> classType;

    public AbstractDao() {

    }

    @Override
    public String getName() {
        return classType.getSimpleName();
    }

    @Override
    public void create(T type) {

        try {


            Session session = hibernateSessionManager.getSession();

            session.save(type);

        } catch (HibernateException ex) {

            throw new TransactionException(ex.getMessage(), ex);
        }

    }

    public T readById(Integer id){

        Session session = hibernateSessionManager.getSession();
        T object = session.get(classType, id);
        return object;

    }

    @Override
    public void update(T type) {

        try {

            Session session = hibernateSessionManager.getSession();
            session.update(type);

        }catch (HibernateException ex){
            throw new TransactionException(ex.getMessage(),ex);
        }
    }

    @Override
    public void delete(T type) {

        try {

            Session session = hibernateSessionManager.getSession();
            session.delete(type);
        }catch (HibernateException ex){
            throw new TransactionException(ex.getMessage(),ex);
        }

    }

    @Override
    public List<T> findAll(){

        try {

            Session session = hibernateSessionManager.getSession();
            Query query = session.createQuery("from " + classType.getSimpleName());
            List allUsers = query.list();
            return allUsers;

        }catch (HibernateException ex){
            throw new TransactionException(ex.getMessage(),ex);
        }

    }

    @Override
    public int count() {

        try {
            Session session = hibernateSessionManager.getSession();

            Query query = session.createQuery ("select count(*) from " + classType.getSimpleName());
            int allUsers = ((Long) query.uniqueResult()).intValue();
            System.out.println(allUsers);
            return allUsers;


        }catch (HibernateException ex){
            throw new TransactionException(ex.getMessage(),ex);
        }
    }

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }
}
