package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @ClassName: SysDict
 * @Description: 系统下拉框字典表
 * @Author: chenq
 * @Date: 2020/10/14 16:48
 * @Version: 1.0
 **/
@Entity
@Setter
@Getter
public class SysDict {

    /**
     * 主键编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父级编号
     */
    private Long pid;

    /**
     * 字典数据类型
     */
    @Column(nullable = false,length = 50)
    private String dataType;

    /**
     * 字典数据编码
     */
    @Column(nullable = false,length = 50)
    private String dataCode;

    /**
     * 字典数据名称/值
     */
    @Column(nullable = false,length = 100)
    private String dataValue;

    /**
     * 顺序号
     */
    @Column(length = 2)
    private Integer sortNo;

    /**
     * 数据状态 1：启用 2：停用 3：删除
     */
    private Integer status;

    /**
     * 字典是否支持修改 0：不支持 1：支持
     */
    @Column(length = 1)
    private Integer isFixed;

    /**
     * 字典描述
     */
    private String dataDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
