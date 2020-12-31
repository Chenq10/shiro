package com.example.shiro.model.req;

import lombok.Data;

/**
 * @ClassName: LoginReqModel
 * @Description:
 * @Author: chenq
 * @Date: 2020/9/24 17:33
 * @Version: 1.0
 **/
@Data
public class LoginReqModel {

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;
}
