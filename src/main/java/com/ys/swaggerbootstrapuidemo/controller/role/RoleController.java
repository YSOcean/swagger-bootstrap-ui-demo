package com.ys.swaggerbootstrapuidemo.controller.role;

import com.ys.swaggerbootstrapuidemo.bean.Role;
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
@Api(tags = "角色管理API服务")
@RestController
@RequestMapping(value = "/api/v1/role")
public class RoleController {

    @ApiOperation("添加角色")
    @PostMapping("/addRole")
    public void addRole(@RequestBody @ApiParam(name="角色对象",value="传入json格式",required=true) Role role){

    }

    @ApiOperation("删除角色")
    @PostMapping("/deleteRole")
    public void deleteRole(@RequestBody @ApiParam(name="角色主键ID",value="传入json格式",required=true) Long roleId){

    }
}
