package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 05/04/17.
 */
public class Event {

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

    String type;
    String period;
    String local;

    public Event(String type, String period, String local) {
        this.type = type;
        this.period = period;
        this.local = local;
    }
}
