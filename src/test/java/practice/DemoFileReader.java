package practice;

import com.crm.autodesk.GenericLib.JASONutilities;

public class DemoFileReader {

	public static void main(String[] args) throws Throwable {
		JASONutilities jsonlib = new JASONutilities();
		String URL = jsonlib.readDataFromJSON("url");
		System.out.println("url:"+URL);
		
		String USERNAME = jsonlib.readDataFromJSON("username");
		System.out.println("Username:"+USERNAME);
		
		String PASSWORD = jsonlib.readDataFromJSON("password");
		System.out.println("Password:"+PASSWORD);
		
	}

}
