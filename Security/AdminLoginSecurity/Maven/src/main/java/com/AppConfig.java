package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Bean;

@EnableWebMvc
@Configuration
@ComponentScan({"com.controller.*"})
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vR = new InternalResourceViewResolver();
		vR.setPrefix("/WEB-INF/views/");
		vR.setSuffix(".jsp");
		return vR;
	}

}
