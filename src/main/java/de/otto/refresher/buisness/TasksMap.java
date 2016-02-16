package de.otto.refresher.buisness;

import java.util.HashMap;

/**
 * Created by Garrit Schröder on 16.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */
public class TasksMap extends HashMap<Long, Task> {

    public TasksMap fillWithTestData() {
        Task task1 = new Task("Security: Nur ein Admin kann einen Task anlegen / löschen");
        Task task2 = new Task("Datenbank Anschluss");
        Task task3 = new Task("Testing: Schreiben von Selenium / Unit Tests");
        Task task4 = new Task("Neue Task sollen unten erscheinen: -> sort by dates");
        Task task5 = new Task("Funktion: Tasks hinzufügen.");
        task5.setDone(true);
        Task task6 = new Task("Funktion: Tasks löschen.");
        task6.setDone(true);
        this.put(task1.getId(), task1);
        this.put(task2.getId(), task2);
        this.put(task3.getId(), task3);
        this.put(task4.getId(), task4);
        this.put(task5.getId(), task5);
        this.put(task6.getId(), task6);
        return this;
    }


    public TasksMap getUndone() {
        TasksMap undoneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (!task.isDone()) {
                undoneTasks.put(task.getId(), task);
            }
        }
        return undoneTasks;
    }

    public TasksMap getDone() {
        TasksMap doneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (task.isDone()) {
                doneTasks.put(task.getId(), task);
            }
        }
        return doneTasks;
    }
}
