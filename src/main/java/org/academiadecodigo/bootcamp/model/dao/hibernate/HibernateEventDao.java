package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.model.dao.EventDao;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * Created by codecadet on 06/04/17.
 */
public class HibernateEventDao extends AbstractDao<Event> implements EventDao {



    public Event readById(Integer id){

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from event where id = :id");
        query.setString("id", id.toString());
        Event object = (Event) query.uniqueResult();
        return object;

    }

    @Override
    public Event readByType(String type) {

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from event where type = :type");
        query.setString("type", type);
        Event object = (Event) query.uniqueResult();
        return object;

    }

    @Override
    public Event readByLocal(String local) {

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from event where local = :local");
        query.setString("local", local);
        Event object = (Event) query.uniqueResult();
        return object;
    }

    @Override
    public Event readByPeriod(String period) {

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from event where period = :period");
        query.setString("period", period);
        Event object = (Event) query.uniqueResult();
        return object;
    }


}
