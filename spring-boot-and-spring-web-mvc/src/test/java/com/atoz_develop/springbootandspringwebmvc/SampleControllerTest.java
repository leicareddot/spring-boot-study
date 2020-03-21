package com.atoz_develop.springbootandspringwebmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

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
}
