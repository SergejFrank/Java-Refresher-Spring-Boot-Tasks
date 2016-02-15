package de.otto.refresher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Value("${application.message}")
    private String message;

    @RequestMapping
    public String welcome(Map<String, Object> model) {
        //model.put("time", new Date());
        //model.put("message", this.message);
        return "tasks";
    }
}
