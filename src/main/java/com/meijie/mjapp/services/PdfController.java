package com.meijie.mjapp.services;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meijie.mjapp.pdf.PdfLevel1;

@RestController
public class PdfController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/pdf")
	public void pdf(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("application/pdf");
		Resource resource = resourceLoader.getResource("classpath:static/fonts/Gellix-Regular.ttf");
		
		System.out.println(resource.exists());
		System.out.println(resource.getURI().getPath());
			OutputStream os = response.getOutputStream();
			PdfLevel1 pdf1 = new PdfLevel1(messageSource);
			pdf1.draw("", os, resource.getURI().getPath());
	}
	
}
