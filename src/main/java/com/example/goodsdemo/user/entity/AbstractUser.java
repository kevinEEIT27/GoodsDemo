package com.example.goodsdemo.user.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractUser  {
  @Schema(name = "使用者姓名", description = "使用這姓名，顯示用", example = "jack")
  String name;

}