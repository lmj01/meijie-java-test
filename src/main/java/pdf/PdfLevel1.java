package pdf;

import java.io.OutputStream;

import org.springframework.context.MessageSource;

public class PdfLevel1 extends PdfLevel0 {
	public PdfLevel1(MessageSource messageSource) {
		setMessageSource(messageSource);
	}
	public void draw(String outputPath, OutputStream os) throws Exception {
		init(outputPath, os);
		newPage();
		this.setFontFromPath("2"+"static/libs/fonts/Gellix-Regular.ttf");
		this.drawText("hello world", 50, 50, fontSizeDefault, fontColorDefault);
	}
}
