package com.tiantian.config.tomcatApp;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileConfig {
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("500MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("1000MB");
        return factory.createMultipartConfig();
    }
}
