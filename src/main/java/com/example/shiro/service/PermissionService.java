package com.example.shiro.service;

import com.example.shiro.entity.Permission;
import com.example.shiro.vo.response.BaseResponse;
import com.example.shiro.vo.response.PermissionResponse;

/**
 * @InterfaceName: PermissionService
 * @Description: 权限相关服务接口
 * @Author: chenq
 * @Date: 2020/10/13 16:36
 * @Version: 1.0
 **/
public interface PermissionService {

    /**
     * 查看权限信息
     * @return
     */
    PermissionResponse viewPermission();

    /**
     * 添加权限信息
     * @param permission 要添加的权限信息
     * @return
     */
    BaseResponse addPermission(Permission permission);


    /**
     * 修改权限信息
     * @param permission 要修改的权限信息
     * @return
     */
    BaseResponse updatePermission(Permission permission);


    /**
     * 删除权限信息
     * @param ids 需要删除的id
     * @return
     */
    BaseResponse delPermission(String ids);
}

