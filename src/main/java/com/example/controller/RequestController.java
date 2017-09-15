package com.example.controller;

import com.example.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by steadyjack on 2017/4/1.
 */
@SpringBootTest(classes=DemoApplication.class)// 指定spring-boot的启动类
@RestController
public class RequestController {

    /**
     * 多级反向代理 获取发起请求的客户端的真实IP地址
     * @param request
     * @return
     */
    @RequestMapping("/requestIP")
    public String requestIP(HttpServletRequest request){
        //String ip=request.getHeader("x-forwarded-for");
        String ip=request.getHeader("X-Real-IP");
        System.out.println("ip: "+ip);
        if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip="1:"+request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip ="2:"+ request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip ="3:"+ request.getRemoteAddr();
        }
        return "请求的ip地址 "+ip;
    }

}
