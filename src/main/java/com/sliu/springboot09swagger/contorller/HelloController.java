package com.sliu.springboot09swagger.contorller;

import com.sliu.springboot09swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.sliu.springboot09swagger.controller
 * @ClassName:HelloController
 * @Description:
 * @author:sliu
 * @data 2022/4/30 16:11
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Swagger";
    }

    //只要接口返回值中有实体类，就能够被Swagger扫描到
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
