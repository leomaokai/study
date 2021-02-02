package com.kai.swagger.condif;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {

    //配置了Swagger的Docket实例
    @Bean
    public Docket docket1(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        //通过environment.acceptsProfiles判断是否出来自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                    //配置分组
                .groupName("leo1")
                .select()
                    //RequestHandlerSelectors 配置要扫描接口的方式
                    //basePackage 指定要扫描的包
                    //any() 扫描全部
                    //none() 都不扫描
                    //withClassAnnotation: 扫描类上的注解
                    //withMethodAnnotation: 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.kai.swagger.controller"))
                    //过滤
                //.paths(PathSelectors.ant("/kai/**"))
                .build();
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("leo2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("leo3");
    }

    //配置Swagger信息=apiInfo()
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("kai", "https://github.com/leomaokai", "leomaokai@163.com");

        return new ApiInfo(
                "Kai Swagger API",
                "从入门到夺门而出",
                "1.0",
                "https://github.com/leomaokai",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
