package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Event;

import java.util.List;

/**
 * Created by codecadet on 06/04/17.
 */
public interface EventDao extends InterfaceDao<Event> {


    Event readById(Integer id);

    Event readByType(String type);

    Event readByLocal(String local);

    Event readByPeriod(String period);

    Event getEvent(String local, String period);


}
