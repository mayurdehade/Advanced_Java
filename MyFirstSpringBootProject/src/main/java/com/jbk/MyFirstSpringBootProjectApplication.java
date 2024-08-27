package com.jbk;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
// This import statement brings in the @SpringBootApplication annotation, which enables 
// several key features in a Spring Boot application, including component scanning, 
// auto-configuration, and the ability to define extra configuration on the application class.


// The main class of the Spring Boot application.
// This is the entry point of the application where the Spring Boot application is configured and started.
@SpringBootApplication
public class MyFirstSpringBootProjectApplication {

    // The main method, which is the standard entry point for Java applications.
    // When the application starts, this method is called by the JVM.
    public static void main(String[] args) {
        // SpringApplication.run() is a static method used to launch the Spring Boot application.
        // It sets up the default configuration, starts the Spring application context, 
        // and performs class path scanning to identify Spring components like @Controller, @Service, etc.
        SpringApplication.run(MyFirstSpringBootProjectApplication.class, args);
    }
}
