package com.cxhu.comprehensive;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/*springboot的应用入口*/  
@SpringBootApplication		
public class App extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);	
	}
	
	/*实现外部容器运行spring boot项目*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
	
	// 设置文件上传的大小
	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        // 单个文件最大  
        factory.setMaxFileSize("102400KB");   
        // 设置总上传数据总大小  
        factory.setMaxRequestSize("1024000KB");  
        return factory.createMultipartConfig();  
    }  
}
