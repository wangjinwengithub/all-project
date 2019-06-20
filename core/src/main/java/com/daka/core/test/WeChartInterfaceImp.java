package com.daka.core.test;

import com.alibaba.dubbo.config.annotation.Service;
import com.daka.core.dao.UserMapper;
import com.daka.interf.WeChartInterface;
import com.daka.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeChartInterfaceImp implements WeChartInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> querySomthing() {
        Map<String,String> map=new HashMap<>();
        map.put("静夜思","床前明月光");
        map.put("李清照","昨夜小楼又东风");
        map.put("业神","我业神天下无敌");
        map.put("骚丁","老死骚瞎丁，骚妇团");
        userMapper.insert("业神",3);
        userMapper.insert("骚丁丁",123);
        userMapper.insert("少妇丁",63);
        userMapper.insert("丁少妇",33);
        return map;
    }

    @Override
    public User queryUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        userMapper.insert("丁少妇",33);
        return user;
    }
}
