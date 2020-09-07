package com.portfolio.resume.web.controller.works;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorksController {

    @GetMapping("/works")
    public String works() {

        return "works/works";
    }
}
