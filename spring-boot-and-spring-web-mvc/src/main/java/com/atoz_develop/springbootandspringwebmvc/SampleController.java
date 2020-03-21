package com.atoz_develop.springbootandspringwebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 템플릿 엔진 - Thymeleaf 예제
@Controller
public class SampleController {

    @GetMapping("/hello/thymeleaf")
    public String hello(Model model) {
        model.addAttribute("name", "leica");
        return "hello";
    }
}
