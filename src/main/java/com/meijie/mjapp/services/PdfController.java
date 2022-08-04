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

import com.meijie.mjapp.logic.RequestModel;
import com.meijie.mjapp.pdf.PdfLevel1;

@RestController
public class PdfController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/pdf")
	public void pdf(HttpServletResponse response, HttpServletRequest request, RequestModel model) throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		Resource resourceGellix = resourceLoader.getResource("classpath:static/fonts/Gellix-Regular.ttf");
		Resource resourceSourceHanSansCN = resourceLoader.getResource("classpath:static/fonts/SourceHanSansCN-Normal.otf");
		Resource resourceSimhei = resourceLoader.getResource("classpath:static/fonts/simhei.ttf");
		
		String strLang = model.getLang();
    	if (strLang.isEmpty()) {
    		// 如果没有指定，使用浏览器的可接收的语言
    		String lang = request.getHeader("Accept-Language");
    		System.out.println(lang);
        	String[] supportLang = lang.split(";")[0].split(",");
        	strLang = supportLang[0];
    	}
		System.out.println(resourceSourceHanSansCN.getURI().getPath());
		System.out.println(resourceGellix.getURI().getPath());
		System.out.println(resourceSimhei.getURI().getPath());
		
		OutputStream os = response.getOutputStream();
		PdfLevel1 pdf1 = new PdfLevel1(messageSource, strLang);
		if (strLang.startsWith("zh")) {
			pdf1.draw(model, "", os, 
//					resourceSourceHanSansCN.getURI().getPath()
					resourceSimhei.getURI().getPath()
			);
		} else {
			pdf1.draw(model, "", os, resourceGellix.getURI().getPath());
		}
	}
	
}
