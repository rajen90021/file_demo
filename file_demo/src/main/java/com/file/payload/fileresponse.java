package com.file.payload;

public class fileresponse {

	
	private String filename;
	private String message;
	
	
	
	
	
	public fileresponse(String filename, String message) {
		super();
		this.filename = filename;
		this.message = message;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
