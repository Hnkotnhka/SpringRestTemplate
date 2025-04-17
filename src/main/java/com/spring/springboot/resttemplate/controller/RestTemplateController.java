package com.spring.springboot.resttemplate.controller;

import com.spring.springboot.resttemplate.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    private final UserService userService;

    public RestTemplateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/code")
    public String getFinalCode() {
        return userService.getFullCode();
    }
}
