package de.otto.refresher;

import java.util.Date;

/**
 * Created by Garrit Schröder on 15.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */
public class Task {

    private String message;
    private boolean done;
    private Date createdOn;
    private Date finishedOn;
    private Date dueTo;

    public Task(String message) {
        this.done = false;
        this.createdOn = new Date();
        this.message = message;
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

    public void setDone(boolean done) {
        this.done = done;
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
