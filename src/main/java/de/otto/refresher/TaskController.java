package de.otto.refresher;

import de.otto.refresher.buisness.Task;
import de.otto.refresher.buisness.TasksMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

// ERWEITERUNG FÜR DEN ZWEITEN TAG ALS FREIWÄHLBARE ZUSATZAUFGABE?
//todo Security: Nur ein Admin kann einen Task anlegen.
//todo Database
//todo selenium /unit tests

// WEITERE FUNTIONEN:
//todo clear all done tasks
//todo Sortiermaske für ausstehende Tasks

//todo: WICHTIG: Neue Tasks sollten ganz unten erscheienen.

@Controller
@RequestMapping("/")
public class TaskController {

    @Value("${application.addTaskErrorMessage}")
    private String addTaskErrorMessage;
    private TasksMap tasks = new TasksMap().fillWithTestData();


    @RequestMapping(method = RequestMethod.GET)
    public String taskForm(Model model, RedirectAttributes attr) {
        model.addAttribute("notDoneTasks", tasks.getUndone());
        model.addAttribute("doneTasks", tasks.getDone());
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String taskSubmit(@ModelAttribute Task task, Model model, RedirectAttributes attr) {
        task.setCreatedOn(new Date());
        if (!task.getMessage().trim().equals("")) {
            tasks.put(task.getId(), task);
        } else {
            attr.addFlashAttribute("addTaskError", addTaskErrorMessage);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String setTaskDone(@RequestParam("id") String stringId, Model model) {
        tasks.get(Long.parseLong(stringId)).setDone(true);
        return "redirect:/";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String removeTask(@RequestParam("id") String stringId, Model model) {
        tasks.remove(Long.parseLong(stringId));
        return "redirect:/";
    }
}
