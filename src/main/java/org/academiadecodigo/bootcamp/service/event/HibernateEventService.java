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
    Session session;

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

        try {


            session = hibernateSessionManager.beginTransaction();

            if (!findAll().contains(event)) {
                session.save(event);
            } else {
                return;
            }

            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {

            hibernateSessionManager.roolBackTransaction();
        }
    }

    @Override
    public Event findByType(String name) {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("from event where type = :type");
        query.setString("type", name);
        Event event = (Event) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return event;


    }

    @Override
    public Event findByPeriod(String name) {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("from event where period = :period");
        query.setString("period", name);
        Event event = (Event) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return event;

    }

    @Override
    public Event findByLocal(String name) {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("from event where local = :local");
        query.setString("local", name);
        Event event = (Event) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return event;

    }

    @Override
    public List findAll() {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("SELECT (*) FROM event");
        List eventList = (List) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return eventList;
    }

    @Override
    public int count() {

        int size = 0;

        try {
            Session session = hibernateSessionManager.beginTransaction();
            size = ((Long) session.createQuery("SELECT count (*) from event").uniqueResult()).intValue();
            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            hibernateSessionManager.roolBackTransaction();
        }

        return size;
    }
}
