package com.example.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.example.shiro.model.req.LoginReqModel;
import com.example.shiro.model.resp.BaseResponse;
import com.example.shiro.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginController
 * @Description: 登录相关接口
 * @Author: chenq
 * @Date: 2020/9/24 16:35
 * @Version: 1.0
 **/
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 访问登录页
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "登录页";
    }


    /**
     * 用户登录接口
     * @param user
     * @return
     */
    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginReqModel user){
        log.info("用户登录：" + JSON.toJSONString(user));
        BaseResponse result = loginService.login(user.getLoginName(), user.getPassword());
        return result;
    }

    /**
     * 访问主页
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return "主页";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout() {
        loginService.loginOut();
        return "退出";
    }

    /**
     * 权限测试页
     * @return
     */
    @GetMapping("/403")
    public String unauthorizedRole(){
        return "没有权限";
    }

}
