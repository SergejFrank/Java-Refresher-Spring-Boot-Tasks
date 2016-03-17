package de.otto.refresher;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import de.otto.refresher.database.adapter.TaskRepository;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource(locations = "classpath:application_test.properties")
public class TaskControllerTest extends FluentTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Autowired
    private TaskRepository repository;

    private WebDriver webDriver = new PhantomJSDriver();

    private String taskCssSelector = "li.task";
    private String todoTaskCssSelector = "li.todo-task";
    private String doneTaskCssSelector = "li.done-task";

    @Before
    public void setUp() {
        repository.deleteAll();
        goTo(url());

    }

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    public String url() {
        return "http://localhost:" + serverPort + "/";
    }

    @Test
    public void newTasksCanBeAdded() {
        addNewTask("FindMe");
        assertThat(getTasksByCSSSelector(todoTaskCssSelector), hasItem("FindMe"));
    }

    @Test
    public void setTaskDone() {
        addNewTask("DoneMe");
        clickButtonByTaskName("DoneMe");
        assertThat(getTasksByCSSSelector(todoTaskCssSelector), not(hasItem("DoneMe")));
        assertThat(getTasksByCSSSelector(doneTaskCssSelector), hasItem("DoneMe"));
    }

    @Test
    public void deleteTasks() {
        addNewTask("DeleteMe");
        clickButtonByTaskName("DeleteMe");
        clickButtonByTaskName("DeleteMe");
        assertThat(getTasksByCSSSelector(todoTaskCssSelector), not(hasItem("DeleteMe")));
        assertThat(getTasksByCSSSelector(doneTaskCssSelector), not(hasItem("DeleteMe")));
    }

    public void addNewTask(String taskName) {
        fill(find(".add-todo")).with(taskName);
        submit("#submit_button");
    }

    public ArrayList<String> getTasksByCSSSelector(String cssSelector) {
        if(find("html").size() < 1){
            throw new NullPointerException("Site not loaded");
        }
        FluentList<FluentWebElement> webElementsDone = find(cssSelector);
        ArrayList<String> doneTasks = new ArrayList<>();
        for (FluentWebElement element : webElementsDone) {
            doneTasks.add(element.getText());
        }
        return doneTasks;
    }

    public void clickButtonByTaskName(String taskName) {
        FluentList<FluentWebElement> webElements = find(taskCssSelector);
        for (FluentWebElement element : webElements) {
            if (element.getText().equals(taskName)) {
                element.getElement().findElement(By.cssSelector("button")).click();
                return;
            }
        }
        throw new ElementNotFoundException(taskName,"","");
    }
}