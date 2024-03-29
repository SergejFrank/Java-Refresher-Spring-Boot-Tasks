package de.otto.refresher.buisness;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Date createdOn;

    private Date finishedOn;

    private Date dueTo;

    public Task() {
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

    public void setDone() {
        this.status = TaskStatus.DONE;
        setFinishedOn(new Date());
    }

    public void setInProgress() {
        this.status = TaskStatus.PROGRESS;
    }

    public void setUndone() {
        this.status = TaskStatus.TODO;
    }

    public void softDelete() {
        this.status = TaskStatus.DELETED;
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