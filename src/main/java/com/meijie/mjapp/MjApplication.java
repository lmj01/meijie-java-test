package com.meijie.mjapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.meijie.mjapp.utils.appProperties;

/**
 * @author meiji
 *
 */
@SpringBootApplication
@ComponentScan(value = "com.meijie")
public class MjApplication {
	
	public static void main(String[] args) {
		appProperties properties = new appProperties();
		SpringApplication.run(MjApplication.class, args);
		System.out.println("meijie java test");
		System.out.println(String.format("port is %s", properties.getProperty("server.port")));
	}
	
}
