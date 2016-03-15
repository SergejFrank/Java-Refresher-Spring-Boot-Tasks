package de.otto.refresher.buisness;

import java.util.LinkedHashMap;

public class TasksMap extends LinkedHashMap<Long, Task> {

    public static TasksMap testData() {
        TasksMap taskMap = new TasksMap();
        Task task5 = new Task("Funktion: Tasks hinzufügen.");
        task5.setDone();
        Task task6 = new Task("Funktion: Tasks löschen.");
        task6.setDone();
        taskMap.put(new Task("Security: Nur ein Admin kann einen Task anlegen / löschen"));
        taskMap.put(new Task("Datenbank Anschluss"));
        taskMap.put(new Task("Testing: Schreiben von Fluentlenium Tests"));
        taskMap.put(new Task("Neue Task sollen unten erscheinen: -> sort by dates"));
        taskMap.put(new Task("multiple lists -> Drag'n'Drop??? (à la trello)"));
        taskMap.put(task5);
        taskMap.put(task6);
        return taskMap;
    }

    public TasksMap getUndone() {
        TasksMap undoneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (task.getStatus() == TaskStatus.TODO) {
                undoneTasks.put(task);
            }
        }
        return undoneTasks;
    }

    public TasksMap getDone() {
        TasksMap doneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (task.getStatus() == TaskStatus.DONE) {
                doneTasks.put(task);
            }
        }
        return doneTasks;
    }

    public Task put(Task task) {
        return this.put(task.getId(), task);
    }
}
