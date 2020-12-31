package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: Permission
 * @Description: 权限类
 * @Author: chenq
 * @Date: 2020/9/24 14:57
 * @Version: 1.0
 **/
@Entity
@Setter
@Getter
public class Permission {

    /**
     * 权限编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;

    /**
     * 权限名称
     */
    @Column(nullable = false)
    private String permissionName;

    /**
     * 资源类型 button menu
     */
    // @Column(columnDefinition = "enums('menu','button')")
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串
     * 如：
     * menu: role:*
     * button: role:add role:del role:update
     */
    private String permission;

    /**
     * 父级权限编号
     */
    private Long parentId;

    /**
     * 父级权限编号列表
     */
    private String parentIds;

    /**
     * 角色和权限是多对多关系
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "RolePermission",joinColumns = {@JoinColumn(name = "permissionId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles;


}
