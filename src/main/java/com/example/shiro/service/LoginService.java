package com.example.shiro.service;

import com.example.shiro.model.resp.BaseResponse;

/**
 * @InterfaceName: LoginService
 * @Description: 用户登录服务接口
 * @Author: chenq
 * @Date: 2020/9/24 15:57
 * @Version: 1.0
 **/
public interface LoginService {

    /**
     * 用户登录接口
     * @param loginName 登录名
     * @param password 登录密码
     * @return
     */
    BaseResponse login(String loginName,String password);

    /**
     * 退出登录
     */
    void loginOut();
}
