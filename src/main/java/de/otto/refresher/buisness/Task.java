package de.otto.refresher.buisness;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Garrit Schröder on 15.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */

public class Task {
    private long id;
    private String message;
    private boolean done;
    private Date createdOn;
    private Date finishedOn;
    private Date dueTo;

    public Task() {
        this.done = false;
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    public Task(String message) {
        this();
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    public void setUndone() {
        this.done = false;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(Date finishedOn) {
        this.finishedOn = finishedOn;
    }

    public Date getDueTo() {
        return dueTo;
    }

    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }
}