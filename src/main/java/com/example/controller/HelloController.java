package com.example.controller;

import com.example.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steadyjack on 2017/3/22.
 */
@SpringBootTest(classes=DemoApplication.class)// 指定spring-boot的启动类
@RestController
public class HelloController {

    @RequestMapping("/list")
    public String list(){
        return "this is a list!";
    }

}














