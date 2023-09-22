package com.example.goodsdemo.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthRequest {

	private String username;
	@NotBlank
	private String account;
	@NotBlank
	private String password;
}
