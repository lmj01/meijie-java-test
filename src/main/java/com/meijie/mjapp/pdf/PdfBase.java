package com.meijie.mjapp.pdf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Observable;

import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;

/**
 * https://api.itextpdf.com/iText7/java/7.1.8/
 * 可被观察的对象
 * @author meiji
 *
 */
public class PdfBase extends Observable {
	private PdfDocument pdfDoc;
	private Document document;
	private PdfWriter writer;
	private PdfPage page;
	private PdfCanvas canvas;
	private Rectangle pageSize;
	private PdfFont font;
	private MessageSource messageSource; // 多语言版本
	private Integer pageCountInteger;
	private String languageString;
	private float lineHeight;
	private PdfStartPage pdfStartPage = new PdfStartPage();
	public static ThemeScheme theme = new ThemeScheme();
	
	public static int fontSizeDefault = 10;
	
	protected PdfBase() {
		this.pageCountInteger = 0;
	}
	
	// 
	public void open(String outputPath, OutputStream os, @Nullable String format) {
		if (format == null) {
			this.pageSize = new Rectangle(PageSize.A4);
		} else {
			String[] sizeString = format.split(",");			
			if (sizeString.length == 2) {
				System.out.println(String.format("page size : %s, %s", sizeString[0], sizeString[1]));
				this.pageSize = new Rectangle(0, 0, Float.parseFloat(sizeString[0]), Float.parseFloat(sizeString[1]));
			}
			else this.pageSize = new Rectangle(PageSize.A4);
		}
		
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
		this.pdfDoc = new PdfDocument(this.writer);
		this.pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, pdfStartPage);
		this.document = new Document(this.pdfDoc);
		setLineHeight(18);
	}
	
	public void close() {
		this.pdfDoc.removeEventHandler(PdfDocumentEvent.START_PAGE, pdfStartPage);
		this.document.close();
	}
	public double mm2pt(double mm, String dpiString) {
		// 打印设备多数为72
		double dpi = 72;
		if (dpiString != null) dpi = Double.parseDouble(dpiString);
		return mm / 25.4f * dpi;
	}
	public void newPage() {
		this.pageCountInteger++;
		this.page = this.pdfDoc.addNewPage();
		this.canvas = new PdfCanvas(this.page);
	}
	/**
	 * 在repository\com\itextpdf\font-asian\7.1.8的font-asian-7.1.8.jar文件中
	 * com.itextpdf.io.font.cmap_info.txt文件中描述了一些问题
	 * 在PDF中使用字体时有版权问题
	 * @param path
	 * @throws IOException
	 */
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
    	return this.pageSize.getTop() - y;
    }
	protected void drawText(String str, float x, float y, int size, Color color) {
		if (str == null) str = "";
		canvas.saveState()
			.beginText()
			.setFontAndSize(font, size)
			.setColor(color, true)
			.moveText(x, y)
			.showText(toUtf8(str))
			.endText()
			.restoreState();
	}
	// 语言包转换
    public String t(String strCode, @Nullable Object[] args) {
		if (languageString.startsWith("zh")) {
			String aString = messageSource.getMessage(strCode, args, Locale.CHINESE);
//			System.err.println(String.format("sss--%s, %s", aString, strCode));
//			System.out.println("print chinese : " + aString);
			return aString;
		} else {
			String aString = messageSource.getMessage(strCode, args, Locale.ENGLISH);
//			System.out.println("print english : " + aString);
			return aString;
		}
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

	public Rectangle getPageSize() {
		return pageSize;
	}

	public void setPageSize(Rectangle a4) {
		this.pageSize = a4;
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

	public String getLanguageString() {
		return languageString;
	}

	public void setLanguageString(String languageString) {
		this.languageString = languageString;
	}

	public float getLineHeight() {
		return lineHeight;
	}

	public void setLineHeight(float lineHeight) {
		this.lineHeight = lineHeight;
	}
	
}
