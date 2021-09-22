package com.crm.autodesk.GenericLib;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * this class contains generic methods to get the data from DB
 * @author JAnsari
 *
 */
public class DataBaseUtility {
	Driver driverRef;
	Connection con=null;
	public void connectToDB() throws Throwable
	{
	
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
	}
	/**
	 * this method returns the data wrt to coloum index
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	public String getDataFromDB(String query,int coloumnindex) throws Throwable {
		String value=null;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value=result.getString(coloumnindex);
		}
		return value;
	}
}
