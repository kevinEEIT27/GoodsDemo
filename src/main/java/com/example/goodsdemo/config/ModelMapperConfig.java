package com.example.goodsdemo.config;

import com.example.goodsdemo.user.dto.UserDto;
import com.example.goodsdemo.user.entity.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

//https://blog.csdn.net/fly_duck/article/details/110203890
@Configuration
public class ModelMapperConfig {
	private final Converter<Date, String> dateStringConverter = new AbstractConverter<Date, String>() {
		@Override
		protected String convert(Date date) {
			SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			return date == null ? null : simpleFormatter.format(date);
		}
	};

	/**
	 * setFullTypeMatchingRequired 設置為true
	 * 將 setMatchingStrategy 設置為 MatchingStrategies.STRICT
	 * 避免字段缺失被相似自段錯誤轉換
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// 完全匹配 建議要開啟
		modelMapper.getConfiguration().setFullTypeMatchingRequired(true);

		// 匹配策略使用嚴格模式
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.addConverter(dateStringConverter);

		configureUser(modelMapper);

		return modelMapper;
	}

	private void configureUser(ModelMapper modelMapper) {

		modelMapper.typeMap(User.class, UserDto.class)
			.addMappings(mapper -> mapper.skip(UserDto::setPassword));
	}
}
