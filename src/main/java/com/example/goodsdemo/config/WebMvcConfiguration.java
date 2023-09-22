package com.example.goodsdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			// 表明允许哪些域访问, 简单点可为 *
			.allowedOrigins("*")
			.allowedHeaders("*")
			.allowedMethods("*")
			// allowCredentials(true): 表示附带身份凭证
			// 一旦使用 allowCredentials(true) 方法，则 allowedOrigins("*") 需要指明特定的域，而不能是 *
			.maxAge(86400);
	}
}