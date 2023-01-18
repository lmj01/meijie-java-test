package com.meijie.mjapp.logic;

public class RequestModel {
	private String lang; // 语言
	private String name; // 名称-特指一切名称
	private String type; // 类型

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
