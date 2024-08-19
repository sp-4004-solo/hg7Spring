package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer{
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		registry.addResourceHandler("/images/**")//이미지를 보여준다
		.addResourceLocations("file:///c:/upload/");//c에 업로드해서 
	
	
	
	}//addResourceHandler
}//class ImageConfig implements
