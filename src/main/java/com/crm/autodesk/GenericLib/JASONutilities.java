package com.crm.autodesk.GenericLib;

import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author JAnsari
 *
 */
public class JASONutilities 
{
/**
 * this method reads the data from json file
 * @throws Throwable 
 */
	public String readDataFromJSON(String key) throws Throwable
	{
	
	//read the data from json file.
	FileReader file=new FileReader("./commonData.json");
	//convert the json file into java object.
	JSONParser jsonobj=new JSONParser();
	Object jobj = jsonobj.parse(file);
	
	//type cast java object to hashmap.
	HashMap<Object,Object> map=(HashMap<Object, Object>)jobj;
	String value = map.get(key).toString();
	
	//return the value.
	return value;
	

}
}