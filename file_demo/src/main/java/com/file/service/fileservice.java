package com.file.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface fileservice {

	
	public String uplpoadimage(String path ,MultipartFile file) throws IOException;
	
	
	public InputStream    getresource(String path,String filename) throws FileNotFoundException;
	
}
