package com.daka.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping("/client")
    public String socket() {
        System.out.print("收到请求！！！！！！！！！！");
        return "websocket";
    }

    @RequestMapping("/dakas")
    public String daka(){
        return "daka";
    }
}
