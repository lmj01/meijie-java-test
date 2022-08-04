package com.meijie.mjapp.pdf;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;

public class ThemeScheme {
	
	private Color fontDefaultColor = new DeviceRgb(255, 124, 123);
	private int fontDefaultSize = 10;
	private float lineHeight = 18.0f;
	private Lang lang;
	private Font font;
	
	public enum Lang {
		ENGLISH,
		CHINESE,
	}
	
	public enum Font {
		Gellix("gellix", 1), SourceHanSansCN("sourceHanSansCN", 1), Simhei("simhei", 1);
		private final String fontName;
		private final int type; // 1 ttf 
		private Font(String fontName, int type) {
			this.fontName = fontName;
			this.type = type;
		}
		public String getFontName() {
			return fontName;
		}
		public int getType() {
			return type;
		}
	}

	public Color getFontDefaultColor() {
		return fontDefaultColor;
	}

	public void setFontDefaultColor(Color fontDefaultColor) {
		this.fontDefaultColor = fontDefaultColor;
	}

	public int getFontDefaultSize() {
		return fontDefaultSize;
	}

	public void setFontDefaultSize(int fontDefaultSize) {
		this.fontDefaultSize = fontDefaultSize;
	}

	public Lang getLang() {
		return lang;
	}

	public void setLang(Lang lang) {
		this.lang = lang;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public float getLineHeight() {
		return lineHeight;
	}

	public void setLineHeight(float lineHeight) {
		this.lineHeight = lineHeight;
	}
	
}
