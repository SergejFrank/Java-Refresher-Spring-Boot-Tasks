package de.otto.refresher;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource(locations = "classpath:application.properties")
public class TaskControllerTest extends FluentTest {

    @Value("${local.server.port}")
    private int serverPort;

    private WebDriver webDriver = new PhantomJSDriver();

    @Before
    public void setUp() {

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
        goTo(url());
        fill(find(".add-todo")).with("FINDME");
        submit("#submit_button");

        FluentList<FluentWebElement> webElements = find("li.todo-task");
        ArrayList<String> todoTasks = new ArrayList<>();
        for (FluentWebElement element : webElements) {
            todoTasks.add(element.getText());
        }

        assertThat(todoTasks, hasItem("FINDME"));

    }

    @Test
    public void setTaskDone() {
        goTo(url());
        fill(find(".add-todo")).with("DoneMe");
        submit("#submit_button");

        FluentList<FluentWebElement> webElements = find("li.todo-task");
        ArrayList<String> todoTasks = new ArrayList<>();
        for (FluentWebElement element : webElements) {
            if (element.getText().equals("DoneMe")) {
                element.find("button").click();
            }


            todoTasks.add(element.getText());
        }

        assertThat(todoTasks, hasItem("DoneMe"));

    }

    @Test
    public void deleteTasks() {

    }


}