package com.example.shiro.vo;

import lombok.Data;

/**
 * @ClassName: PageInfo
 * @Description: 分页信息类
 * @Author: chenq
 * @Date: 2020/10/13 16:41
 * @Version: 1.0
 **/
@Data
public class PageInfo {

    /**
     * 当前页码
     */
    private String pageIndex;

    /**
     * 页面容量
     */
    private String pageSize;

    /**
     * 数据总条数
     */
    private String totalCount;

    /**
     * 总页数
     */
    private String totalPageCount;
}
