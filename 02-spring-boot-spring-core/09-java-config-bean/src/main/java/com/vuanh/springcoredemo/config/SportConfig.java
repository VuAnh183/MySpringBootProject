package com.vuanh.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vuanh.springcoredemo.common.Coach;
import com.vuanh.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean("swim")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
