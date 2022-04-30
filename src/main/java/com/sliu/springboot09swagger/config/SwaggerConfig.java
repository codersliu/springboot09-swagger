package com.sliu.springboot09swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @PackageName:com.sliu.springboot09swagger.config
 * @ClassName:SwaggerConfig
 * @Description:
 * @author:sliu
 * @data 2022/4/30 16:27
 */
@Configuration
@EnableSwagger2     //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

//    配置Swagger的Docket的Bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        //通过environment.acceptsProfiles判断是否处于所设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("sliu")
                //enable是否开启Swagger
                .enable(flag)
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage:指定要扫描的包，最常用方式
                //any():全部扫描
                //none():全不扫描
                //withClassAnnotation:扫描类上的注解，参数为注解反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.sliu.springboot09swagger.contorller"))
                //paths()配置过滤白名单
                .paths(PathSelectors.ant("/hello"))
                .build();
    }

    //配置Swagger信息apiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact(
                "sliu",
                "http://shunliu.xyz",
                "shunliu@csu.edu.cn");
        return new ApiInfo("sliu的SwaggerAPI主页",
                "Please teach me coding",
                "v.1.0",
                "https://shunliu.xyz",
                contact,
                "Apache 2.0",
                "http://www.apache/org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
