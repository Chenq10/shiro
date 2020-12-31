package com.example.shiro.dao;

import com.example.shiro.entity.SysDict;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName: SysDictDao
 * @Description: 数据字典服务数据库接入层
 * @Author: chenq
 * @Date: 2020/10/14 17:18
 * @Version: 1.0
 **/
@Repository
public interface SysDictDao extends BaseRepository<SysDict,Long> {

}
