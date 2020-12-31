package com.example.shiro.controller;

import com.example.shiro.service.UserService;
import com.example.shiro.vo.UserAddParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: UserController
 * @Description: 用户相关接口
 * @Author: chenq
 * @Date: 2020/9/24 16:36
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //用户查询
    @GetMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public String userInfo(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        log.info("用户名称；" + session.getAttribute("loginName"));
        return "userList";
    }

    //用户添加
    @GetMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public String userInfoAdd(UserAddParams params){

        userService.addUser(params);
        return "userAdd";
    }

    //用户删除
    @GetMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public String userDel(){
        return "userDel";
    }
}
