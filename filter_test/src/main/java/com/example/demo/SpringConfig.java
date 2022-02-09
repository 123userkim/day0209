package com.example.demo;

import javax.servlet.FilterRegistration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.filter.SistFilter;


@Configuration
public class SpringConfig implements WebMvcConfigurer {
	
	@Bean//객체 제공자
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean filterRegistrationBean 
		= new FilterRegistrationBean(new SistFilter());
		
		
		filterRegistrationBean.addUrlPatterns("/member/*");
		return filterRegistrationBean;
	}
}
