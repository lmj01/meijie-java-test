package logic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
	@RequestMapping("/pdf")
	String ReturnPdf() {
		return "hello world";
	}
}
