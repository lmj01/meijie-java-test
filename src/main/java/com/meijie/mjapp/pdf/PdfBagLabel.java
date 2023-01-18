package com.meijie.mjapp.pdf;

import java.io.OutputStream;

import org.springframework.context.MessageSource;

import com.itextpdf.kernel.colors.Color;
import com.meijie.mjapp.logic.RequestModel;
import com.meijie.mjapp.logic.events.listenGenPdf;

public class PdfBagLabel extends PdfBase {
	public PdfBagLabel(MessageSource messageSource, String langString) {
		setMessageSource(messageSource);
		setLanguageString(langString);
		this.addObserver(new listenGenPdf());
	}
	public void draw(RequestModel model, String outputPath, OutputStream os, String fontPath) throws Exception {
		open(outputPath, os, "60,40");
		Color color1 = theme.getFontDefaultColor();
		this.setLineHeight(40);
		// 第一页
		newPage();
		this.setFontFromPath(fontPath);
		float y = 10;
		float x = 10;
		this.drawText("hello world in page 1", x, y, fontSizeDefault, color1);
		y += getLineHeight();
		this.drawText("test.l1", x, y, fontSizeDefault, color1);
		y += getLineHeight();
		this.drawText("test.l2", x, y, fontSizeDefault, color1);
		y += getLineHeight();
		this.drawText("中文测试代码", x, y, fontSizeDefault, color1);
			    
	    setChanged();
	    notifyObservers("PdfBagLabel");	    
		close();
	}
}
