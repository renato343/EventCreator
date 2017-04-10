package org.academiadecodigo.bootcamp.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 05/04/17.
 */
public class Event {

    private Integer id;
    private String type;
    private String period;
    private String local;

    private int numberOfPlayers;
    private List<User> eventUsersList;


    public List<User> getEventUsersList() {
        return eventUsersList;
    }

    public void setEventUsersList(List<User> eventUsersList) {
        this.eventUsersList = eventUsersList;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = this.numberOfPlayers + numberOfPlayers;
    }

    public Event() {
        this.eventUsersList = new LinkedList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (period != null ? !period.equals(event.period) : event.period != null) return false;
        return local != null ? local.equals(event.local) : event.local == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (local != null ? local.hashCode() : 0);
        return result;
    }
}
