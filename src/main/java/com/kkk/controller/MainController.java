package com.kkk.controller;

import com.kkk.bean.ResultBean;
import com.kkk.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By z3jjlzt on 2017/10/16
 */
@RestController
public class MainController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/joke/{id}")
    public ResultBean getJoke(@PathVariable Integer id) {
        return jokeService.getJoke(id);
    }

}
