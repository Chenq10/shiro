package com.example.shiro.vo.response;

import com.example.shiro.vo.PageInfo;
import lombok.Data;

/**
 * @ClassName: PageResponse
 * @Description:
 * @Author: chenq
 * @Date: 2020/10/14 9:42
 * @Version: 1.0
 **/
@Data
public class PageResponse extends BaseResponse {

    private PageInfo page = new PageInfo();
}
