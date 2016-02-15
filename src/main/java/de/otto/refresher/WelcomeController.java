package de.otto.refresher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Value("${application.message}")
    private String message;
    private HashMap<Long, Task> tasks = new HashMap<Long, Task>();

    private HashMap<Long, Task> getNotDoneTasks() {
        HashMap<Long, Task> notDoneTasks = new HashMap<Long, Task>();
        for (Task task : tasks.values()) {
            if (!task.isDone()) {
                notDoneTasks.put(task.getId(), task);
            }
        }
        return notDoneTasks;
    }

    private HashMap<Long, Task> getDoneTasks() {
        HashMap<Long, Task> doneTasks = new HashMap<Long, Task>();
        for (Task task : tasks.values()) {
            if (task.isDone()) {
                doneTasks.put(task.getId(), task);
            }
        }
        return doneTasks;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("notDoneTasks", getNotDoneTasks());
        model.addAttribute("doneTasks", getDoneTasks());
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String taskSubmit(@ModelAttribute Task task, Model model) {
        task.setCreatedOn(new Date());
        tasks.put(task.getId(), task);
        return "redirect:/";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String setTaskDone(@RequestParam("id") String stringId, Model model) {
        long id = Long.parseLong(stringId);
        tasks.get(id).setDone(true);
        return "redirect:/";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String removeTask(@RequestParam("id") String stringId, Model model) {
        long id = Long.parseLong(stringId);
        tasks.remove(id);
        return "redirect:/";
    }
}
