package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: User
 * @Description: 用户类
 * @Author: chenq
 * @Date: 2020/9/24 14:56
 * @Version: 1.0
 **/
@Entity
@Getter
@Setter
public class User {

    /**
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long userId;

    /**
     * 用户姓名
     */
    @Column(nullable = false)
    private String userName;

    /**
     * 用户登录名
     */
    @Column(nullable = false,unique = true)
    private String loginName;

    /**
     * 用户密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 用户和角色之间的关系为 一个用户多个角色
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "UserRole",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles;


}
