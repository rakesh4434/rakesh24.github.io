package com.tcs.org.util;

import org.springframework.beans.factory.annotation.Value;

public class MNAConstants {

	 @Value("${pdfFilePath}")
	public static String PDF_FILE_PATH;
	 
	 @Value("${pdfFileName}")
	 public static String PDF_FILE_NAME; 
	
}
