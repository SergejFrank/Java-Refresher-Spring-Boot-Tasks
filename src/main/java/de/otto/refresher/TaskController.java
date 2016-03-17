package de.otto.refresher;

import de.otto.refresher.buisness.Task;
import de.otto.refresher.buisness.TaskStatus;
import de.otto.refresher.database.adapter.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    @Value("${application.addTaskErrorMessage}")
    private String addTaskErrorMessage;

    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String taskForm(Model model, @RequestParam(value = "sort", required = false) String sort) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (sort != null) {
            switch (sort) {
                case "desc":
                    direction = Sort.Direction.DESC;
            }

        }
        model.addAttribute("notDoneTasks", taskRepository.findTaskByStatus(TaskStatus.TODO));
        model.addAttribute("doneTasks", taskRepository.findTaskByStatus(TaskStatus.DONE, new Sort(direction, "finishedOn")));
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String taskSubmit(@ModelAttribute Task newTask, RedirectAttributes attr) {
        if (!newTask.getMessage().trim().isEmpty()) {
            newTask.setCreatedOn(new Date());
            taskRepository.save(newTask);
        } else {
            attr.addFlashAttribute("addTaskError", addTaskErrorMessage);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String setTaskDone(@RequestParam("id") String stringTaskId) {
        Task task = taskRepository.findTaskById(Long.parseLong(stringTaskId));
        task.setDone();
        taskRepository.save(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String removeTask(@RequestParam("id") String stringTaskId) {
        Task task = taskRepository.findTaskById(Long.parseLong(stringTaskId));
        task.softDelete();
        taskRepository.save(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
    public String removeAllTask() {
        List<Task> tasks = taskRepository.findTaskByStatus(TaskStatus.DONE);
        for (Task task : tasks) {
            task.softDelete();
            taskRepository.save(task);
        }
        return "redirect:/";
    }
}
