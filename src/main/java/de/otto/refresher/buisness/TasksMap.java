package de.otto.refresher.buisness;

import de.otto.refresher.Task;

import java.util.HashMap;

/**
 * Created by Garrit Schröder on 16.02.16.
 * Email: GarritSidney.Schroeder@otto.de
 */
public class TasksMap extends HashMap<Long, Task> {

    public TasksMap getUndone() {
        TasksMap notDoneTasks = new TasksMap();
        for (Task task : this.values()) {
            if (!task.isDone()) {
                notDoneTasks.put(task.getId(), task);
            }
        }
        return notDoneTasks;
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
