package com.meijie.mjapp.pdf;

import java.io.OutputStream;

import org.springframework.context.MessageSource;

import com.meijie.mjapp.logic.RequestModel;

public class PdfLevel1 extends PdfLevel0 {
	public PdfLevel1(MessageSource messageSource, String langString) {
		setMessageSource(messageSource);
		setLanguageString(langString);
	}
	public void draw(RequestModel model, String outputPath, OutputStream os, String fontPath) throws Exception {
		open(outputPath, os);
		newPage();
		this.setFontFromPath(fontPath);
		float y = 10;
		float x = 10;
		this.drawText("hello world", x, y, fontSizeDefault, fontColorDefault);
		y += getLineHeight();
		this.drawText(t("test.l1", null), x, y, fontSizeDefault, fontColorDefault);
		y += getLineHeight();
		this.drawText(t("test.l2", new Object[] {model.getName()}), x, y, fontSizeDefault, fontColorDefault);
		close();
	}
}
