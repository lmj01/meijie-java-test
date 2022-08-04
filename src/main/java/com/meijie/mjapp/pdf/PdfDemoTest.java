package com.meijie.mjapp.pdf;

import java.io.OutputStream;

import org.springframework.context.MessageSource;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.meijie.mjapp.logic.RequestModel;

public class PdfDemoTest extends PdfBase {
	public PdfDemoTest(MessageSource messageSource, String langString) {
		setMessageSource(messageSource);
		setLanguageString(langString);
	}
	public void draw(RequestModel model, String outputPath, OutputStream os, String fontPath) throws Exception {
		open(outputPath, os);
		Color color1 = theme.getFontDefaultColor();
		// 第一页
		newPage();
		this.setFontFromPath(fontPath);
		float y = 10;
		float x = 10;
		this.drawText("hello world in page 1", x, y, fontSizeDefault, color1);
		y += getLineHeight();
		this.drawText(t("test.l1", null), x, y, fontSizeDefault, color1);
		y += getLineHeight();
		this.drawText(t("test.l2", new Object[] {model.getName()}), x, y, fontSizeDefault, color1);
		
		//	第二页
		newPage();
		x = y = 10;
		this.drawText("hello world in page 2", x, y, fontSizeDefault, color1);
	    Div div = new Div();
	    div.setWidth(UnitValue.createPercentValue(100));
	    div.setHeight(UnitValue.createPercentValue(100));
	    div.setHorizontalAlignment(HorizontalAlignment.CENTER);
	    Paragraph p1 = new Paragraph();
	    p1.setHorizontalAlignment(HorizontalAlignment.CENTER);
	    p1.setMaxWidth(UnitValue.createPercentValue(75));
	    p1.setMarginTop(180f);
	    p1.setCharacterSpacing(0.4f);
	    Style large = new Style();
	    large.setFontSize(22);
	    large.setFontColor(color1);
	    p1.add(new Text("尊敬的 ").addStyle(large));
	    Paragraph p2 = new Paragraph();
	    div.add(p1);
	    div.add(p2);
	    this.getDocument().add(div);
		
		close();
	}
}
