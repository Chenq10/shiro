package com.example.shiro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @InterfaceName: BaseRepository
 * @Description: 数据访问层基础类
 * @Author: chenq
 * @Date: 2020/9/24 15:52
 * @Version: 1.0
 **/
@NoRepositoryBean
public interface BaseRepository<T, I extends Serializable>  extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
