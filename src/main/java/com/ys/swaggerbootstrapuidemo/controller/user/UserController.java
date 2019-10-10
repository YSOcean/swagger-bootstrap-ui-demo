package com.ys.swaggerbootstrapuidemo.controller.user;

import com.ys.swaggerbootstrapuidemo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Copyright (C), 2015-2019, kxjl.com
 * @ Author:   shuaiyu
 * @ Date:     Created in 2019/10/8 13:37
 * @ Description:
 * @ Modified By：
 * @ Version: 1.0
 */
@Api(tags = "用户管理API服务")
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {


    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public void addUser(@RequestBody @ApiParam(name="user",value="用户对象",required=true) User user){

    }


    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody @ApiParam(name="userId",value="用户主键id",type="Long",required=true) Long userId){

    }
}
