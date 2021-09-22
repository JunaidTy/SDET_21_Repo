package com.crm.autodesk.GenericLib;

import java.util.Date;
import java.util.Random;
/**
 * This class contain generic methods pertaining to java
 * @author JAnsari
 *
 */

public class JavaUtility 
{
	/**
	 * This Method operates random number
	 * @return
	 */
  public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}
  public String getSystmeDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString().replaceAll(":", "-");
		return systemDateAndTime;
}
}
