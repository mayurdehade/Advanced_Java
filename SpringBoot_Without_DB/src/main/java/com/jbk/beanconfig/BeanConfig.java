package com.jbk.beanconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jbk.model.Department;

//Configuration class for Bean annotation
@Configuration
public class BeanConfig {

	// @Bean annotation provide metadata
	@Bean
	public List<Department> getList() {
		return new ArrayList<Department>();
	}
}
