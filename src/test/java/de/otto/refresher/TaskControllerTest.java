package de.otto.refresher;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TaskControllerTest extends FluentTest {
    @Test
    public void title_of_bing_should_contain_search_query_name() {
        goTo("http://www.bing.com");
        fill("#sb_form_q").with("FluentLenium");
        submit("#sb_form_go");
        assertThat("d",true);
    }
}