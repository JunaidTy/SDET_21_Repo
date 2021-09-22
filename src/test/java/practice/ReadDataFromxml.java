package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromxml {
		@Test
		public void readDataFromXML(XmlTest xmlobj)
		{
			System.out.println(xmlobj.getParameter("browser"));
			System.out.println(xmlobj.getParameter("url"));
			System.out.println(xmlobj.getParameter("username"));
			System.out.println(xmlobj.getParameter("password"));
			

	}

}
