package com.daka.wechart.controller;

import com.daka.model.User;
import com.daka.wechart.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/query")
    public Object querySomeThing(){
        return testService.querySomeThing();
    }

    @RequestMapping("/queryUser")
    public User queryUser(String id){
        return testService.queryUser(id);
    }
}
