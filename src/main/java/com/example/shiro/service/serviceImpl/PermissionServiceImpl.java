package com.example.shiro.service.serviceImpl;

import com.example.shiro.dao.PermissionDao;
import com.example.shiro.entity.Permission;
import com.example.shiro.service.PermissionService;
import com.example.shiro.vo.response.BaseResponse;
import com.example.shiro.vo.response.PermissionResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName: PermissionServiceImpl
 * @Description: 权限信息服务实现
 * @Author: chenq
 * @Date: 2020/10/13 16:37
 * @Version: 1.0
 **/
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public PermissionResponse viewPermission() {
        PermissionResponse result = new PermissionResponse();
        result.setData(IteratorUtils.toList(permissionDao.findAll().iterator()));
        return result;
    }

    @Override
    public BaseResponse addPermission(Permission permission) {
        BaseResponse result = new BaseResponse();
        permissionDao.save(permission);
        return result;
    }

    @Override
    public BaseResponse updatePermission(Permission permission) {
        BaseResponse result = new BaseResponse();
        permissionDao.save(permission);
        return result;
    }

    @Override
    public BaseResponse delPermission(String ids) {
        BaseResponse result = new BaseResponse();
        if(StringUtils.isNotBlank(ids)){
            String[] idArr = ids.split(",");
            for (String s : idArr) {
                long dbId = NumberUtils.toLong(s);
                permissionDao.deleteById(dbId);
            }
        }
        return result;
    }
}
