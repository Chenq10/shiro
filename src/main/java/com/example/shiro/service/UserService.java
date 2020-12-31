package com.example.shiro.service;

import com.example.shiro.entity.User;
import com.example.shiro.vo.UserAddParams;

/**
 * @InterfaceName: UserService
 * @Description: 用户服务接口
 * @Author: chenq
 * @Date: 2020/9/24 15:57
 * @Version: 1.0
 **/
public interface UserService {

    /**
     * 通过用户登录名查找用户
     * @param loginName 用户登录名
     * @return
     */
    User findUserByLoginName(String loginName);


    /**
     * 新增用户信息
     * @param params 新增用户信息参数
     */
    void addUser(UserAddParams params);
}
