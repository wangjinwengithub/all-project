package com.daka.core;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
/** 现在还没有配置数据源，加上该注解，让spring先不加载数据源**/
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableDubbo(scanBasePackages = "com.daka.core")
@EnableHystrix
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
