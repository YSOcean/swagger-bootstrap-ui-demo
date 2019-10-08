package com.ys.swaggerbootstrapuidemo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value="user对象",description="用户对象user")
public class User {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("密码")
    private String userPwd;
    @ApiModelProperty("创建人")
    private Integer createUser;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("更新人")
    private Integer updateUser;
    @ApiModelProperty("更新时间")
    private Long updateTime;
    @ApiModelProperty("备注")
    private String userDesc;

}