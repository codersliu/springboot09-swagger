package com.sliu.springboot09swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @PackageName:com.sliu.springboot09swagger.pojo
 * @ClassName:User
 * @Description:
 * @author:sliu
 * @data 2022/4/30 21:32
 */
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
