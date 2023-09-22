package com.example.goodsdemo.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsFilterConfiguration {

	@Bean
	public CorsFilter corsFilter() {
		// 建立 CorsConfiguration 後添加配置
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 設定放行哪些原始域
		corsConfiguration.addAllowedOrigin("*");
		// 放行哪些原始請求Header
		corsConfiguration.addAllowedHeader("*");
		// 放行哪些請求方法
		corsConfiguration.addAllowedMethod("*");

		// 添加映射路径
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(source);
	}

}