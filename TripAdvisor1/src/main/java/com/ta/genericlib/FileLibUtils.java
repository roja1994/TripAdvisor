package com.ta.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLibUtils {
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fObj=new FileInputStream("./src/main/resources/propertyfile.properties");
		Properties pObj = new Properties();
		pObj.load(fObj);
		return pObj.getProperty(key);
	}
}
