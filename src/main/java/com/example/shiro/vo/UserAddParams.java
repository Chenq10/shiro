package com.example.shiro.vo;

import lombok.Data;

/**
 * @ClassName: UserAddParams
 * @Description: 新增用户参数
 * @Author: chenq
 * @Date: 2020/10/12 14:18
 * @Version: 1.0
 **/
@Data
public class UserAddParams {


    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;


    /**
     * 新增用户对应的角色ids
     */
    private String roleIds;


    /**
     * 用户名
     */
    private String userName;



}
