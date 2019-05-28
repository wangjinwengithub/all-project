package com.daka.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理全局异常，出异常统一由这里返回
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}
