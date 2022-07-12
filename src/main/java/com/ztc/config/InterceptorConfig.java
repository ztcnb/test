package com.ztc.config;

import com.ztc.interceptor.TokenInterceptor;
import com.ztc.util.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Map;

/**
 * 拦截器配置
 *
 * @author Administrator
 */
//@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器：1、要拦截的路径（拦截所有） 2、拦截器处理类
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


}
