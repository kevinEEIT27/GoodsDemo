package com.example.goodsdemo.user.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Schema(title = "使用者", description = "用以註冊，輸入密碼登入")
public class User extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	@Schema(name = "使用者ID", description = "自動產生的使用者編號", example = "1", format = "int")
	private Long userID;
	@NotEmpty(message = "user account should not be empty")
	@Column(unique = true)
	@Schema(name = "帳號", description = "作為登入使用，作為帳號不可重複")
	private String account;
	@NotEmpty(message = "user password should not be empty")
	@Schema(name = "密碼", description = "加密後存於資料庫中")
	private String password;
}
