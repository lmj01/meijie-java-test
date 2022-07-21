package com.meijie.meijiejavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置数据库了，但是没有使用，启动时先屏蔽掉数据库的配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class MeijieJavaTestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MeijieJavaTestApplication.class, args);
		System.out.println("meijie java test");
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
