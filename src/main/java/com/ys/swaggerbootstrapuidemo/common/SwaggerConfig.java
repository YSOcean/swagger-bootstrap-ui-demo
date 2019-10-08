package com.ys.swaggerbootstrapuidemo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yuShuai
 * @Description: Swagger2的接口配置
 * @Date: 2019/10/8 13:41
 * @params:
 * @return:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${config.swaggerConfig.isShow}")
    private Boolean isShow;


    @Bean
    public Docket createUserRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isShow)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                .groupName("用户管理API")
                // 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ys.swaggerbootstrapuidemo.controller.user"))
                // 扫描所有有注解的api
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.kxjl.belleps.api"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createRoleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isShow)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                .groupName("角色管理API")
                // 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ys.swaggerbootstrapuidemo.controller.role"))
                // 扫描所有有注解的api
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.kxjl.belleps.api"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("标题：Swagger测试_接口文档")
                // 描述
                .description("描述：Swagger测试相关接口信息")
                // 作者信息
                .contact(new Contact("ShuaiYu", "https://www.cnblogs.com/ysocean/", "1827165732@163.com"))
                // 版本
                .version("版本号:" + "1.0")
                .build();
    }
}
