package com.example.shiro.service.serviceImpl;

import com.example.shiro.enums.ResponseCodeEnum;
import com.example.shiro.model.resp.BaseResponse;
import com.example.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


/**
 * @ClassName: LoginServiceImpl
 * @Description: 登录服务接口实现
 * @Author: chenq
 * @Date: 2020/9/24 16:07
 * @Version: 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public BaseResponse login(String loginName, String password) {
        BaseResponse loginResult = new BaseResponse();
        if (loginName == null || loginName.isEmpty()) {
            loginResult.setCode(ResponseCodeEnum.LOGIN_NAME_IS_NULL.getCode());
            loginResult.setMsg(ResponseCodeEnum.LOGIN_NAME_IS_NULL.getMsg());
            return loginResult;
        }
        ResponseCodeEnum code ;
        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);

        // 4、认证
        try {
            currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
            Session session = currentUser.getSession();
            session.setAttribute("loginName", loginName);
            loginResult.setCode(ResponseCodeEnum.SUCCESS.getCode());
            return loginResult;
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            code = ResponseCodeEnum.NO_USER;
        } catch (IncorrectCredentialsException e) {
            code = ResponseCodeEnum.PASSWORD_FAIL;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            code = ResponseCodeEnum.LOGIN_FAIL;
        }

        loginResult.setCode(code.getCode());
        loginResult.setMsg(code.getMsg());

        return loginResult;
    }

    @Override
    public void loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
