package com.daka.interf;

import com.daka.model.User;

import java.util.Map;

public interface WeChartInterface {

    Map<String,String> querySomthing();

    User queryUser(int id);
}
