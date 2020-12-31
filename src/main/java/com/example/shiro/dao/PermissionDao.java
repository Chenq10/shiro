package com.example.shiro.dao;

import com.example.shiro.entity.Permission;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: PermissionDao
 * @Description: 权限信息数据库接入层
 * @Author: chenq
 * @Date: 2020/10/13 16:26
 * @Version: 1.0
 **/
@Repository
public interface PermissionDao extends BaseRepository<Permission,Long> {

}
