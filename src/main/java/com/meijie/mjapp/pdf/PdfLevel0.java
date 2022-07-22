package com.meijie.mjapp.pdf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.context.MessageSource;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;

public class PdfLevel0 {
	private PdfDocument pdfDoc;
	private Document document;
	private PdfWriter writer;
	private PdfPage page;
	private PdfCanvas canvas;
	private Rectangle a4;
	private PdfFont font;
	private MessageSource messageSource; // 多语言版本
	private Integer pageCountInteger;
	
	public static int fontSizeDefault = 10;
	public static Color fontColorDefault = new DeviceRgb(255, 124, 123);
	
	protected PdfLevel0() {
		this.pageCountInteger = 0;
	}
	
	// 
	public void open(String outputPath, OutputStream os) {
		this.a4 = new Rectangle(PageSize.A4);
		if (os != null) {
			this.writer = new PdfWriter(os);
		} else {
			try {
				this.writer = new PdfWriter(outputPath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.pdfDoc = new PdfDocument(writer);
		this.document = new Document(pdfDoc);
	}
	
	public void close() {
		this.document.close();
	}
	
	public void newPage() {
		pageCountInteger++;
		page = pdfDoc.addNewPage();
		canvas = new PdfCanvas(page);
	}
	
	protected void setFontFromPath(String path) throws IOException {
		if (path == null) {
    		this.font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
    	} else {
    		this.font = PdfFontFactory.createFont(path, PdfEncodings.IDENTITY_H, true);	
    	}
	}
	
	public String toUtf8(String srcStr) {
		return new String(srcStr.getBytes(StandardCharsets.UTF_8));
	}
	protected float toy(float y) {
		// 因为坐标的原点是左下角，从上往下绘制时，距离位置是要反转一下的
    	return PageSize.A4.getTop() - y;
    }
	protected void drawText(String str, float x, float y, int size, Color color) {
		if (str == null) str = "";
		canvas
		.saveState()
		.beginText()
		.setFontAndSize(font, size)
		.setColor(color, true)
		.moveText(x, toy(y))
		.showText(str)
		.endText()
		.restoreState();
	}
	
	public PdfDocument getPdfDoc() {
		return pdfDoc;
	}

	public void setPdfDoc(PdfDocument pdfDoc) {
		this.pdfDoc = pdfDoc;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public PdfWriter getWriter() {
		return writer;
	}

	public void setWriter(PdfWriter writer) {
		this.writer = writer;
	}

	public PdfPage getPage() {
		return page;
	}

	public void setPage(PdfPage page) {
		this.page = page;
	}

	public PdfCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(PdfCanvas canvas) {
		this.canvas = canvas;
	}

	public Rectangle getA4() {
		return a4;
	}

	public void setA4(Rectangle a4) {
		this.a4 = a4;
	}

	public PdfFont getFont() {
		return font;
	}

	public void setFont(PdfFont font) {
		this.font = font;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Integer getPageCountInteger() {
		return pageCountInteger;
	}

	public void setPageCountInteger(Integer pageCountInteger) {
		this.pageCountInteger = pageCountInteger;
	}
	
}