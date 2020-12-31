package com.example.shiro.enums;

/**
 * @EnumName: PermissionEnum
 * @Description: 权限的枚举
 * @Author: chenq
 * @Date: 2020/10/13 17:01
 * @Version: 1.0
 **/
public enum PermissionEnum {

    PERMISSION_VIEW("查看权限","view"),
    PERMISSION_ADD("新增权限","add"),
    PERMISSION_UPDATE("修改权限","update"),
    PERMISSION_DEL("删除权限","del"),
    ;
    private String permissionName;
    private String code;

    PermissionEnum(String permissionName,String code){
        this.permissionName = permissionName;
        this.code = code;
    }
}
