package com.meijie.mjapp.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	/**
	 * spring boot默认返回的html中是拒绝使用iframe的，需要配置
	 * @return
	 */
	@RequestMapping(value = "/pdfindex")
	public String pdfHtml(HttpServletResponse response) {
		response.setHeader("x-frame-options", "SAMEORIGIN");
		return "pdf";
	}
}
