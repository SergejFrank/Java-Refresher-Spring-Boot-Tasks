package de.otto.refresher.buisness;

import java.util.HashMap;

/**
 * Created by Garrit Schröder on 16.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */
public class TasksMap extends HashMap<Long, Task> {

    public TasksMap() {
        Task task1 = new Task("Security: Nur ein Admin kann einen Task anlegen / löschen");
        Task task2 = new Task("Datenbank Anschluss");
        Task task3 = new Task("Testing: Schreiben von Selenium / Unit Tests");
        this.put(task1.getId(), task1);
        this.put(task2.getId(), task2);
        this.put(task3.getId(), task3);
    }


    public TasksMap getUndone() {
        TasksMap undoneTasks = new TasksMap();
        //todo remove
        undoneTasks.clear();
        for (Task task : this.values()) {
            if (!task.isDone()) {
                undoneTasks.put(task.getId(), task);
            }
        }
        return undoneTasks;
    }

    public TasksMap getDone() {
        TasksMap doneTasks = new TasksMap();
        // TODO remove
        doneTasks.clear();
        for (Task task : this.values()) {
            if (task.isDone()) {
                doneTasks.put(task.getId(), task);
            }
        }
        return doneTasks;
    }
}
