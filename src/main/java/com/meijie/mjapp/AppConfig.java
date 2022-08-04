package com.meijie.mjapp;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages/message");
		resource.setDefaultEncoding("UTF-8");
		resource.setDefaultLocale(Locale.ENGLISH);
		resource.setUseCodeAsDefaultMessage(false);
		return resource;
	}
	
}
