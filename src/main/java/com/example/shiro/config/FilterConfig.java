package com.example.shiro.config;

import com.example.shiro.filter.CustomFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FilterConfig
 * @Description:
 * @Author: chenq
 * @Date: 2020/9/25 11:11
 * @Version: 1.0
 **/
@Configuration
public class FilterConfig {

    @Bean

    public RemoteIpFilter remoteIpFilter() {

        return new RemoteIpFilter();

    }



    @Bean

    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new CustomFilter());//添加过滤器

        registration.addUrlPatterns("/login");//设置过滤路径，/*所有路径

        registration.addInitParameter("name", "alue");//添加默认参数

        registration.setName("CustomFilter");//设置名称

        registration.setOrder(1);//设置优先级

        return registration;

    }

}
