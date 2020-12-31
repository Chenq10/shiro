package com.example.shiro.controller;

import com.example.shiro.entity.Permission;
import com.example.shiro.service.PermissionService;
import com.example.shiro.vo.response.BaseResponse;
import com.example.shiro.vo.response.PermissionResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PermissionController
 * @Description: 权限相关访问接口
 * @Author: chenq
 * @Date: 2020/10/13 16:25
 * @Version: 1.0
 **/
@RestController
@RequestMapping("permission")
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    /**
     * 查看权限配置
     * @return
     */
    @RequestMapping("/permissionList")
    @RequiresPermissions("permission:view")
    public PermissionResponse viewPermission(){
        PermissionResponse result = permissionService.viewPermission();
        return result;
    }

    /**
     * 新增权限操作
     * @param permission
     * @return
     */
    @RequestMapping("/permissionAdd")
    @RequiresPermissions("permission:add")
    public BaseResponse addPermission(Permission permission){
        BaseResponse result = permissionService.addPermission(permission);
        return result;
    }


    /**
     * 修改权限信息
     * @param permission
     * @return
     */
    @RequestMapping("/permissionUpdate")
    @RequiresPermissions("permission:update")
    public BaseResponse updatePermission(Permission permission){
        BaseResponse result = permissionService.updatePermission(permission);
        return result;
    }


    /**
     * 删除权限信息
     * @param ids 需要删除的权限id
     * @return
     */
    @RequestMapping("/permissionDel")
    @RequiresPermissions("permission:del")
    public BaseResponse delPermission(String ids){
        BaseResponse result = permissionService.delPermission(ids);
        return result;
    }

}
