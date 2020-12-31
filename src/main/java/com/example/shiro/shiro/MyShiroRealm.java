package com.example.shiro.shiro;

import com.alibaba.fastjson.JSON;
import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @ClassName: MyShiroRealm
 * @Description:
 * @Author: chenq
 * @Date: 2020/9/24 16:15
 * @Version: 1.0
 **/
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 身份认证:验证用户输入的账号和密码是否正确。
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的账号
        String userName = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findUserByLoginName(userName);
        if (user == null) {
            return null;
        }
        log.info("数据库用户信息：" + JSON.toJSONString(user));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(), ByteSource.Util.bytes("1235"),this.getName());
        return authenticationInfo;
    }

    /**
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        // 传对象对内存消耗比较大？
        String loginName  = (String)principals.getPrimaryPrincipal();
        User user = userService.findUserByLoginName(loginName);
        for(Role role : user.getRoles()){
            //添加角色
            authorizationInfo.addRole(role.getRoleName());
            for(Permission p:role.getPermissions()){
                //添加权限
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

}