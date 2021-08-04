package com.project.gamerfront.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.gamerfront.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {

	@Bean
	public CustomErrorDecoder mCystomErrorDecoder() {
		return new CustomErrorDecoder();
	}
}
