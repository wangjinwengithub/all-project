package com.daka.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.daka.interf.TestInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Reference
    TestInterface inter;

    @RequestMapping("/web")
    @ResponseBody
    public Object testWeb(String name){
        String test=inter.test();
        testAop(name,test);
        return "yes"+name+test;
    }

    public void testAop(String name,String sex){

        System.out.print("name:"+name+"   sex:"+sex);
    }

}
