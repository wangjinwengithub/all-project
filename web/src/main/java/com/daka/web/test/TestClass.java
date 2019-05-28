package com.daka.web.test;

import com.alibaba.dubbo.config.annotation.Service;
import com.daka.interf.TestInterface;

@Service
public class TestClass implements TestInterface {

    @Override
    public String test() {
        return null;
    }
}
