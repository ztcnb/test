package com.ztc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhoum
 * @date 2022-03-17 14:15
 */
@Configuration
public class UploadConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //所有的访问图片的路径("/images/**")都映射到本地目录，即访问("/images/**")等同于访问（file:xxx）路径
        registry.addResourceHandler("/images/**") //访问的路经
                //本地保存图片路径
                .addResourceLocations("file:D:\\IDEA代码\\First4\\src\\main\\resources\\static\\images\\");
    }

}
