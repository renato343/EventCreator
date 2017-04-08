package org.academiadecodigo.bootcamp.service.event;

import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

import java.util.List;

/**
 * Created by Renato on 08/04/17.
 */
public interface EventService extends Service{

    void addEvent(Event event);

    Event findByType(String name);

    Event findByPeriod(String name);

    Event findByLocal(String name);

    List findAll();

    int count();

}
