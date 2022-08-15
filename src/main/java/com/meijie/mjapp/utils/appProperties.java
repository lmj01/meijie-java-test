package com.meijie.mjapp.utils;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class appProperties {
	private ClassPathResource resource;
	private Optional<Properties> propsProperties;
	public appProperties() {
		resource = new ClassPathResource("application.properties");
		try {
			propsProperties = Optional.of(PropertiesLoaderUtils.loadProperties(resource));
		} catch (IOException e) {
			e.printStackTrace();
			propsProperties = null;
		}
	}
	public String getProperty(String key) {
		if (propsProperties.isPresent()) {
			return propsProperties.get().getProperty(key);
		}
		return "";
	}
}
