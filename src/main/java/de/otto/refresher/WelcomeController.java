package de.otto.refresher;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Value("${application.message}")
    private String message;
    private ArrayList<Task> tasks = new ArrayList<>();

    private ArrayList<Task> getNotDoneTasks() {
        ArrayList<Task> notDoneTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isDone()) {
                notDoneTasks.add(task);
            }
        }
        return notDoneTasks;
    }

    private ArrayList<Task> getDoneTasks() {
        ArrayList<Task> doneTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                doneTasks.add(task);
            }
        }
        return doneTasks;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("notDoneTasks", getNotDoneTasks());
        model.addAttribute("doneTasks", getDoneTasks());
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Task task, Model model) {
        model.addAttribute("newTask", task);
        task.setCreatedOn(new Date());
        tasks.add(task);
        model.addAttribute("notDoneTasks", getNotDoneTasks());
        model.addAttribute("doneTasks", getDoneTasks());
        return "tasks";
    }
}
