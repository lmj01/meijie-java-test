package com.meijie.mjapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

import com.meijie.mjapp.services.mjUserDetailsService;

/**
 * 配置数据库了，但是没有使用，启动时先屏蔽掉数据库的配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class MjAppApplication {
	@Autowired
	static MessageSource messageSource;
	@Autowired
	static mjUserDetailsService mjUserDetailsService;
	
	public static void main(String[] args) {
		SpringApplication.run(MjAppApplication.class, args);
		System.out.println("meijie java test");
	}
	
}
