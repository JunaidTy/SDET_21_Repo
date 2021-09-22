package com.crm.autodesk.GenericLib;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
		public String getPropertyFileData(String key) throws Throwable
			{
			FileInputStream fis=new FileInputStream(IpathConstants.PropertyFilePath);
			Properties p=new Properties();
			p.load(fis);
			String value=p.getProperty(key);
			
			return value;
			}
	}
