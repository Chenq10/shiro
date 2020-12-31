package com.example.shiro.model.resp;

import com.example.shiro.enums.ResponseCodeEnum;
import lombok.Data;

/**
 * @ClassName: BaseResponse
 * @Description: 基础的响应类
 * @Author: chenq
 * @Date: 2020/9/24 15:37
 * @Version: 1.0
 **/
@Data
public class BaseResponse {

    /**
     * 响应码 默认值：200
     */
    private String code = ResponseCodeEnum.SUCCESS.getCode();

    /**
     * 响应信息 默认值：成功
     */
    private String msg = ResponseCodeEnum.SUCCESS.getMsg();

    /**
     * 响应数据
     */
    private Object data;
}
