package com.jbk;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jbk.container.Student;

@SpringBootApplication
public class IocContainerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IocContainerApplication.class, args);
		
		//created bean (@Component annotation provide metadata to IOC)
		//if @Component annotation is not there then exception is occur no such bean available
		Student bean = context.getBean(Student.class);
		
		System.out.println(bean);
//		Student s = new Student(123, "xyz");
		
		
		
	}

}
