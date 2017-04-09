package org.academiadecodigo.bootcamp.service.event;

import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.model.dao.EventDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by codecadet on 06/04/17.
 */
public class EventServiceImpl implements EventService {

    private EventDao eventDao;
    private List eventsList;


    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public EventServiceImpl() {
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Transactional
    @Override
    public String getName() {
        return EventService.class.getSimpleName();
    }

    @Transactional
    @Override
    public void addEvent(Event eventToBeLocated) {

        System.out.println(eventToBeLocated.getLocal());
        System.out.println(eventToBeLocated.getPeriod());

        if(eventDao.readByLocal(eventToBeLocated.getLocal()) == null ||
                eventDao.readByPeriod(eventToBeLocated.getPeriod()) == null){
            System.out.println("vou adicionar");
            eventDao.create(eventToBeLocated);
        }else {
            System.out.println("nao adicionei");
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
