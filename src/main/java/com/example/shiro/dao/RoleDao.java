package com.example.shiro.dao;

import com.example.shiro.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: RoleDao
 * @Description: 角色信息数据库接入层
 * @Author: chenq
 * @Date: 2020/10/13 16:26
 * @Version: 1.0
 **/
@Repository
public interface RoleDao extends BaseRepository<Role,Long> {
}
