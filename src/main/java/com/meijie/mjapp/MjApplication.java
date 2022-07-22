package com.meijie.mjapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.meijie")
public class MjApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MjApplication.class, args);
		System.out.println("meijie java test");
	}
	
}
