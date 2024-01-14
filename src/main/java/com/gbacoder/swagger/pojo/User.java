package com.gbacoder.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author alanulog
 * @create 2024-01-14
 */
@ApiModel("User Entity")
public class User {

    @ApiModelProperty("Username")
    public String name;
    @ApiModelProperty("Password")
    public String password;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
