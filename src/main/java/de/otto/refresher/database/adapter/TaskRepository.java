package de.otto.refresher.database.adapter;

import de.otto.refresher.buisness.Task;
import de.otto.refresher.buisness.TaskStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TaskRepository extends Repository<Task, Long> {

    List<Task> findAll();

    Task save(Task task);

    List<Task> findTaskByStatus(TaskStatus status);

    List<Task> findTaskByStatus(TaskStatus status, Sort sort);

    Task findTaskById(Long id);

    void deleteAll();


}