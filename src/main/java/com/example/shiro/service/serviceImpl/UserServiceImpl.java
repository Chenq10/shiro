package com.example.shiro.service.serviceImpl;

import com.example.shiro.dao.UserDao;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import com.example.shiro.vo.UserAddParams;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务接口实现
 * @Author: chenq
 * @Date: 2020/9/24 16:08
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findUserByLoginName(String loginName) {
        return userDao.findUserByLoginName(loginName);
    }

    @Override
    public void addUser(UserAddParams params) {

        // 构建用户基本信息
        String loginName = params.getLoginName();
        String password = params.getPassword();
        String userName = params.getUserName();

        User user = new User();

        user.setLoginName(loginName);
        user.setPassword(password);
        user.setUserName(userName);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        String roleIds = params.getRoleIds();

        String[] roleList = roleIds.split(",");
        List<Role> roles = new ArrayList<>();
        for (String s : roleList) {
            Role role = new Role();
            role.setRoleId(NumberUtils.toLong(s));
            roles.add(role);

        }
        user.setRoles(roles);

        // 保存用户信息
        userDao.save(user);


    }
}
