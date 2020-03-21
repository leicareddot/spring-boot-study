package com.atoz_develop.springbootandspringwebmvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void hello() throws Exception {
        mvc.perform(get("/hello/thymeleaf"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("hello"))    // view 이름 확인
                .andExpect(model().attribute("name", is("leica"))) // model - name=leica
                .andExpect(content().string(containsString("leica")));
    }

    // HtmlUnit을 사용한 테스트
    @Autowired
    WebClient webClient;

    @Test
    public void helloWithHtmlUnit() throws Exception {
        HtmlPage page = webClient.getPage("/hello/thymeleaf");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("leica");
    }
}
