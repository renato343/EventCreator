package org.academiadecodigo.bootcamp.service.event;

import org.academiadecodigo.bootcamp.model.dao.EventDao;

/**
 * Created by codecadet on 06/04/17.
 */
public class EventServiceImpl {
    private EventDao eventDao;

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
