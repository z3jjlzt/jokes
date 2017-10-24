package com.kkk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Create By z3jjlzt on 2017/10/22
 */
@Controller
public class BaseController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
