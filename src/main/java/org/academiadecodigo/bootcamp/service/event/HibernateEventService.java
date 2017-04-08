package org.academiadecodigo.bootcamp.service.event;

import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by codecadet on 22/03/17.
 */
public class HibernateEventService implements EventService {

    HibernateSessionManager hibernateSessionManager;

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }


    @Override
    public String getName() {
        return UserService.class.getSimpleName();
    }

    @Override
    public void addEvent(Event event) {

    }

    @Override
    public Event findByType(String name) {
        return null;
    }

    @Override
    public Event findByPeriod(String name) {
        return null;
    }

    @Override
    public Event findByLocal(String name) {
        return null;
    }
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int count() {

        int size = 0;

        try {
            Session session = hibernateSessionManager.beginTransaction();
            size = ((Long) session.createQuery("SELECT count (*) from User").uniqueResult()).intValue();
            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            hibernateSessionManager.roolBackTransaction();
        }

        return size;
    }
}
