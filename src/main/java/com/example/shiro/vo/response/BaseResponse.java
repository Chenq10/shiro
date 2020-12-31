package com.example.shiro.vo.response;

import com.example.shiro.enums.ResponseCodeEnum;
import lombok.Data;

/**
 * @ClassName: BaseResponse
 * @Description: 基础响应类
 * @Author: chenq
 * @Date: 2020/10/13 16:39
 * @Version: 1.0
 **/
@Data
public class BaseResponse {

    private String code = ResponseCodeEnum.SUCCESS.getCode();

    private String message = ResponseCodeEnum.SUCCESS.getMsg();


}
