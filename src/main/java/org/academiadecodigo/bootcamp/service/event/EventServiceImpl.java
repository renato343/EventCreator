package org.academiadecodigo.bootcamp.service.event;

import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.model.dao.EventDao;

import java.util.List;

/**
 * Created by codecadet on 06/04/17.
 */
public class EventServiceImpl implements EventService {

    private EventDao eventDao;
    private List eventsList;

    public EventServiceImpl() {
    }

    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public String getName() {
        return EventService.class.getSimpleName();
    }

    @Override
    public void addEvent(Event event) {

        if(!findAll().contains(event)) {
            eventDao.create(event);
        }

    }

    @Override
    public Event findByType(String type) {

        Event event;
        event = eventDao.readByType(type);
        return event;
    }

    @Override
    public Event findByPeriod(String period) {

        Event event;
        event = eventDao.readByPeriod(period);
        return event;
    }

    @Override
    public Event findByLocal(String name) {

        Event event;
        event = eventDao.readByLocal(name);
        return event;
    }


    @Override
    public List findAll() {

        this.eventsList = eventDao.findAll();
        return eventsList;

    }

    @Override
    public int count() {
        int count;
        count = eventDao.count();
        return count;
    }
}
