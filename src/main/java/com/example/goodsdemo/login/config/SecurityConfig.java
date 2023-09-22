package com.example.goodsdemo.login.config;

import com.example.goodsdemo.filter.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;

	/**
	 * 「/user」這個 API 及其底下的所有 GET 請求，需通過身份驗證才可存取。
	 * 其餘 API 的所有GET請求，允許所有呼叫方存取。
	 * 「/user」這個 API 的 POST 請求，允許所有呼叫方存取。
	 * 其餘的所有 API，需通過身份驗證才可存取。
	 *
	 * @param http HttpSecurity
	 * @throws Exception
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "api/*/user/**").authenticated()
			.antMatchers(HttpMethod.POST, "/api/*/user").permitAll()
			.antMatchers("/swagger-ui.html",
				"/swagger-ui/**",
				"/swagger-resources/**",
				"/v3/api-docs/**",
				"/v2/api-docs",
				"/v3/api-docs",
				"/webjars/**").permitAll()
			.antMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
			.antMatchers(HttpMethod.POST, "/h2/**").permitAll()
			.antMatchers("/h2/**").permitAll()
			.antMatchers(HttpMethod.POST, "/auth/*").permitAll()
			.antMatchers(HttpMethod.POST, "/auth/parse").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.cors().and()
			.csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}