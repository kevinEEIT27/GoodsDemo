package com.example.goodsdemo.message.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Schema(title = "商品物件", description = "商品")
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	@Schema(name = "商品ID", description = "自動產生的商品流水號", example = "1", format = "int")
	private Long id;

	@NotBlank(message = "Goods name should not be Blank")
	@Schema(name = "商品名稱")
	private String name;
}
