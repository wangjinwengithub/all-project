package com.daka.wechart.controller;

import com.daka.model.User;
import com.daka.wechart.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/data")
    public Object getData(){
        List<Map<String,String>> resultList=new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("subject","2019年学费");
        map.put("startTime","20190620");
        map.put("endTime","20190623");
        map.put("remark","死老丁交学费啦");
        resultList.add(map);
        map = new HashMap<>();
        map.put("subject","2019年考试学费");
        map.put("startTime","20180620");
        map.put("endTime","20190623");
        map.put("remark","");
        resultList.add(map);

        map = new HashMap<>();
        map.put("subject","2017年语文费用学费");
        map.put("startTime","20170620");
        map.put("endTime","20190623");
        map.put("remark","");
        resultList.add(map);

        map = new HashMap<>();
        map.put("subject","2019年瞎写点学费");
        map.put("startTime","20190620");
        map.put("endTime","20190623");
        map.put("remark","春季学费");
        resultList.add(map);
        int i=0;
        while(i++<50){
            map = new HashMap<>();
            map.put("subject","2019年学费");
            map.put("startTime","20190620");
            map.put("endTime","20190623");
            map.put("remark","死老丁交学费啦");
            resultList.add(map);
        }
        return resultList;
    }

    @RequestMapping("/data1")
    public Object getData1(){
        Map<String,Object> resultMap=new HashMap<>();
        Map<String,String> buyErInfo=new HashMap<>();
        Map<String,String> subjectInfo=new HashMap<>();
        buyErInfo.put("name","小丁姓丁");
        buyErInfo.put("idNo","110104196206102121");
        buyErInfo.put("email","uifrank@163.com");
        buyErInfo.put("phone","uifrank@163.com");
        resultMap.put("buyErInfo",buyErInfo);

        subjectInfo.put("xuefei","100");
        subjectInfo.put("zhushu","100");
        subjectInfo.put("alreadyFee","100");
        subjectInfo.put("unFee","100");
        subjectInfo.put("feeTime","2019.11.19 12:00:53");
        subjectInfo.put("status","已收款");
        resultMap.put("subjectInfo",subjectInfo);
        resultMap.put("orderId","57479681");
        return resultMap;
    }

    @RequestMapping("/data2")
    public Object data2(){
        List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("number","57479681");
            resultMap.put("card_no","110104196206102121");
            resultMap.put("amount","200");
            resultMap.put("alreadyAmount","200");
            resultMap.put("time","2019.11.19 12:00:53");
            resultMap.put("name","死老骚瞎丁丁糖");
            list.add(resultMap);
        }
        return list;

    }
}
