package com.daka.wechart.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.daka.interf.WeChartInterface;
import com.daka.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestService {

    @Reference()
    private WeChartInterface weChartInterface;

    public Map<String,String> querySomeThing() {
        return  weChartInterface.querySomthing();
    }

    public User queryUser(String id){
        User o = weChartInterface.queryUser(Integer.valueOf(id));
        return o;
    }
}
