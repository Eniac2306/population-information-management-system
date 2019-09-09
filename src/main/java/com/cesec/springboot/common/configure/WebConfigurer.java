package com.cesec.springboot.common.configure;

import com.cesec.springboot.system.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 李帅龙
 * date 2019/8/19 14:06
 * @version 1.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    //获取loginInterceptor
    @Autowired
    private LoginInterceptor loginInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(loginInterceptor);
        //排除配置，以下请求不进行拦截

        //登录接口
        addInterceptor.excludePathPatterns("/first/login");
        addInterceptor.excludePathPatterns("/img/*");
        addInterceptor.excludePathPatterns("/css/*");
        addInterceptor.excludePathPatterns("/js/*");

        //1
        addInterceptor.excludePathPatterns("/test");
        //跳转到找回密码页面
        addInterceptor.excludePathPatterns("/toFindPassWord");
        //跳转到登录页面
        addInterceptor.excludePathPatterns("/hello");
        //拦截配置，以下请求进行拦截
        addInterceptor.addPathPatterns("/**");

    }
}
