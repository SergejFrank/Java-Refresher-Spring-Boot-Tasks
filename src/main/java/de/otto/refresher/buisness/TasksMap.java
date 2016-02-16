package de.otto.refresher.buisness;

import java.util.HashMap;

/**
 * Created by Garrit Schröder on 16.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */
public class TasksMap extends HashMap<Long, Task> {

    public TasksMap fillWithTestData() {
        Task task5 = new Task("Funktion: Tasks hinzufügen.");
        task5.setDone();
        Task task6 = new Task("Funktion: Tasks löschen.");
        task6.setDone();
        this.put(new Task("Security: Nur ein Admin kann einen Task anlegen / löschen"));
        this.put(new Task("Datenbank Anschluss"));
        this.put(new Task("Testing: Schreiben von Selenium / Unit Tests"));
        this.put(new Task("Neue Task sollen unten erscheinen: -> sort by dates"));
        this.put(task5);
        this.put(task6);
        return this;
    }

    public TasksMap getUndone() {
        TasksMap undoneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (!task.isDone()) {
                undoneTasks.put(task);
            }
        }
        return undoneTasks;
    }

    public TasksMap getDone() {
        TasksMap doneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (task.isDone()) {
                doneTasks.put(task);
            }
        }
        return doneTasks;
    }

    public Task put(Task task) {
        return this.put(task.getId(), task);
    }
}
