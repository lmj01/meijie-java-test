package com.meijie.mjapp.pdf;

import java.io.OutputStream;

import org.springframework.context.MessageSource;

public class PdfLevel1 extends PdfLevel0 {
	public PdfLevel1(MessageSource messageSource) {
		setMessageSource(messageSource);
	}
	public void draw(String outputPath, OutputStream os, String fontPath) throws Exception {
		open(outputPath, os);
		newPage();
		this.setFontFromPath(fontPath);
		this.drawText("hello world", 10, 10, fontSizeDefault, fontColorDefault);
		close();
	}
}
