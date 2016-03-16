package de.otto.refresher;

import org.fluentlenium.adapter.FluentTest;
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

import static org.hamcrest.MatcherAssert.assertThat;


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
        fill(find(".add-todo")).with("FluentLenium");
        submit("#submit_botton");
        assertThat("d", true);
    }
}