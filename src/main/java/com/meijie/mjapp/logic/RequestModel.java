package com.meijie.mjapp.logic;

public class RequestModel {
	private String lang; // 语言
	private String name; // 名称-特指一切名称

	RequestModel() {
		lang = "";
		name = "_black_";
	}
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
