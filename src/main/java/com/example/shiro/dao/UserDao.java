package com.example.shiro.dao;

import com.example.shiro.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: UserDao
 * @Description: 用户类数据库访问层
 * @Author: chenq
 * @Date: 2020/9/24 15:53
 * @Version: 1.0
 **/
@Repository
public interface UserDao extends BaseRepository<User,Long> {

    User findUserByLoginName(String loginName);

}
