package com.example.goodsdemo.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @author Kevin kao
 * @version 1.0
 **/
@SpringBootConfiguration
@OpenAPIDefinition(
	// ## API的基本信息，包括標題、版本號、描述、作者等
	info = @Info(
		title = "Swagger3.0 (Open API) 登入認證與商品模組",       // Api接口文檔標題（必填）
		description = "此為登入驗證及查詢商品等功能基本模組",      // Api接口文檔描述
		version = "1.2.1",                                   // Api接口版本
		termsOfService = "https://example.com/",             // Api接口的服务條款地址
		contact = @Contact(
			name = "凱文",                            // 作者名称
			email = "kao850702@gmail.com",                  // 作者邮箱
			url = ""  // 介绍作者的URL地址
		),
		license = @License(                                                // 設置聯繫人信息
			name = "Apache 2.0",                                       // 授權名稱
			url = "https://www.apache.org/licenses/LICENSE-2.0.html"   // 授權內容
		)
	),
	// ## 表示服務器地址或者URL模板列表，多個服務地址随時切換（只不過是有多台IP有當前的服務API）
	servers = {
		@Server(url = "http://localhost:8888/", description = "本地服務器一"),
//		@Server(url = "http://localhost:8888/", description = "本地服務器一二"),
	},
	externalDocs = @ExternalDocumentation(description = "更多內容連結", url = "xxx"))
@SecurityScheme(
	name = "JWT-test",                   // 認證方案名稱
	type = SecuritySchemeType.HTTP,      // 認證類型，當前為http認證
	description = "除註冊與登入外其他都須經過認證",  // 描述信息
	in = SecuritySchemeIn.HEADER,        // 代表在http请求头部
	scheme = "bearer",                   // 認證方案，使用 如：Authorization: bearer token信息
	bearerFormat = "JWT")                // 表示使用 JWT 格式作为 Bearer Token 的格式
public class SwaggerOpenApiConfig {
}