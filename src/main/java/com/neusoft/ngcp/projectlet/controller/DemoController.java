package com.neusoft.ngcp.projectlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/hello")
    public String HelloWorld() {
        return "hello world";
    }
}
