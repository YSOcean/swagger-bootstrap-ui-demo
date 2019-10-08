package com.ys.swaggerbootstrapuidemo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value="role对象",description="角色对象role")
public class Role {
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("角色名称")
    private String roleName;
    @ApiModelProperty("企业ID")
    private Integer businessId;
    @ApiModelProperty("创建人")
    private Integer createUser;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("更新人")
    private Integer updateUser;
    @ApiModelProperty("更新时间")
    private Long updateTime;


}