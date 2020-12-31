package com.example.shiro.enums;

/**
 * @EnumName: ResponseCodeEnum
 * @Description: 响应编号枚举类
 * @Author: chenq
 * @Date: 2020/9/24 15:41
 * @Version: 1.0
 **/
public enum ResponseCodeEnum {

    SUCCESS("200","成功！"),
    FAIL("501","失败！"),
    LOGIN_FAIL("502","登录失败！"),
    AUTH_FAIL("503","鉴权失败！"),
    LOGIN_NAME_IS_NULL("504","用户名为空！"),
    NO_USER("505","账号不存在！"),
    PASSWORD_FAIL("506","密码错误！"),



    ;

    private String code;

    private String msg;

    ResponseCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
