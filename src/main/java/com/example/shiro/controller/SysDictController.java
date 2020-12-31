package com.example.shiro.controller;

import com.example.shiro.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysDictController
 * @Description: 数据字典访问接口
 * @Author: chenq
 * @Date: 2020/10/14 17:19
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/dict")
@Slf4j
public class SysDictController {


    @GetMapping("/get/{type}")
    public BaseResponse getDict(@PathVariable("type") String type){
        BaseResponse result = new BaseResponse();
        return null;
    }

}
