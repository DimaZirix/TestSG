package com.dima.test.sg.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    public ApiController() {
    }

    @GetMapping("/get/")
    public void get() {

    }

    @GetMapping("/add/")
    public void add() {

    }
}
