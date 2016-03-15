package de.otto.refresher.buisness;

import java.util.Date;
import java.util.UUID;

public class Task {
    private long id;
    private String message;
    private TaskStatus status;
    private Date createdOn;
    private Date finishedOn;
    private Date dueTo;

    public Task() {
        setId(UUID.randomUUID().getMostSignificantBits());
        setUndone();
    }

    public Task(String message) {
        this();
        setMessage(message);
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setDone() { this.status = TaskStatus.DONE; }

    public void setUndone() {
        this.status = TaskStatus.TODO;
    }

    public void delete(){ this.status = TaskStatus.DELETED; }

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