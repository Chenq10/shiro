package com.example.shiro.vo.response;

import com.example.shiro.entity.Permission;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PermissionResponse
 * @Description: 权限响应信息类
 * @Author: chenq
 * @Date: 2020/10/13 16:49
 * @Version: 1.0
 **/
@Data
public class PermissionResponse extends PageResponse {

    private List<Permission> data = new ArrayList<>();
}