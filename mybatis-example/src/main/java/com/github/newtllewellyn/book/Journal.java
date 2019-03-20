package com.github.newtllewellyn.book;

import java.math.BigDecimal;

public class Journal extends BookInterface {
	private String editor;
	
	public Journal(String uuid, String name,BigDecimal price, String press) {
		super(uuid, name, price, press);
	}
	
	public Journal(String uuid, String name,BigDecimal price, String press, String editor) {
		super(uuid, name, price, press);
		this.editor = editor;
	}
	 


	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getEditor() {
		return this.editor;
	}
	
}
