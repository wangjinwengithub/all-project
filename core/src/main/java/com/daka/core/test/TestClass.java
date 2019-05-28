package com.daka.core.test;

import com.alibaba.dubbo.config.annotation.Service;
import com.daka.interf.TestInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Service
@Component
public class TestClass implements TestInterface {

    @HystrixCommand
    @Override
    public String test() {
        return "这是一个简单的测试！";
    }
}
