package com.atoz_develop.test.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleController.class)
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    // 어플리케이션 컨텍스트안에 들어있는 SampleService 빈을 여기서 만든 mockbean으로 교체한다.
    // 그러면 테스트에서는 원본 SampleService가 아닌 mock SampleService를 사용한다.
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        // Mocking
        when(mockSampleService.getName()).thenReturn("Yoon");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello Yoon"));
    }
}