package com.example.shiro.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName: CustomCredentialsMatcher
 * @Description: 自定义的密码校验器
 * @Author: chenq
 * @Date: 2020/9/25 9:13
 * @Version: 1.0
 **/
public class CustomCredentialsMatcher extends CodecSupport implements CredentialsMatcher {



    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SimpleAuthenticationInfo info1;
        if(info instanceof SimpleAuthenticationInfo){
            info1 = (SimpleAuthenticationInfo) info;
            ByteSource byteSalt = info1.getCredentialsSalt();
            String salt = new String(byteSalt.getBytes());
            String tokenCredentials =new String((char[]) token.getCredentials());
            String infoCredentials = (String) info.getCredentials();
            if(tokenCredentials.equalsIgnoreCase(infoCredentials)){
                return true;
            }
        }
        return false;
    }


    /**
     * 获取输入的密码信息
     * @param token 需要认证的token
     * @return
     */
    protected Object getCredentials(AuthenticationToken token){
        return token.getCredentials();
    }


    /**
     * 获取服务端的密码信息
     * @param info 服务端信息
     * @return
     */
    protected Object getCredentials(AuthenticationInfo info){
        return info.getCredentials();
    }
}
