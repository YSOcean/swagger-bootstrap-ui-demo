# swagger-bootstrap-ui-demo
swagger-bootstrap-ui 使用实例
### 1.引入jar包
```$xslt
<!-- swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>${swagger.version}</version>
</dependency>

<!-- swagger-bootstrap-ui -->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>${swagger-bootstrap-ui.version}</version>
</dependency>

```  
PS：这里的版本号可以参考源码pom.xml文件。或者到Maven仓库中选取最新的版本。  
①、swagger2仓库地址：https://mvnrepository.com/artifact/io.springfox/springfox-swagger2  
②、swagger-bootstrap-ui仓库地址：https://mvnrepository.com/artifact/com.github.xiaoymin/swagger-bootstrap-ui  



### 2.编写配置文件  
```$xslt
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

```  
PS:相关配置的意思在代码中都有标注，这里需要注意以下两点：  
①、由于swagger是用于生成API文档，那么在生成环境中是不能让别人能够访问的，  
需要需要配置 new Docket(DocumentationType.SWAGGER_2).enable(isShow)  
对于isShow属性，我们可以在application.yml配置文件进行相关设定，true表示显示，false不是不展示。  
applicaion.yml 文件配置：  
```$xslt
config:
  swaggerConfig:
    #是否展示swagger,true表示展示。生产环境中需要置为false,避免暴露接口
    isShow: true
``` 
②、配置文件中，我配置了groupName()属性，这是为了在微服务模式下，模块太多，便于分类展示。  


### 3.访问地址  
>http://${host}:${port}/项目访问地址名称/doc.html  
PS:这里的“项目访问地址名称”是你在配置文件配置了就写，没有配置，这里则没有。  
比如，本项目的配置文件为：  
```$xslt
server:
  port: 8070
  servlet:
    context-path: /swaggerTest
```  
那么，访问地址为：http://localhost:8070/swaggerTest/doc.html  

