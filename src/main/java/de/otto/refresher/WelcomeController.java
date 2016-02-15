package de.otto.refresher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Value("${application.message}")
    private String message;

    @RequestMapping(method = RequestMethod.GET)
    public String greetingForm(Model model) {

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("task1"));
        tasks.add(new Task("task2"));
        model.addAttribute("notDoneTasks", tasks);
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Task task, Model model) {
        model.addAttribute("newTask", task);
        task.setCreatedOn(new Date());
        return "tasks";
    }
}
