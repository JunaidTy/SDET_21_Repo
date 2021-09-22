package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromMYSQL_DB {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
		//register the mysql database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//get connected to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");

		//create sql statement
		Statement stat = con.createStatement();
		String query="insert into students_info(regno,firstname,middlename,lastname) values('11','gam','hassan')";
	
		//execute statement/query
		int result = stat.executeUpdate(query);
		if(result==1) {
			System.out.println("user is created");
					}
		}
		catch(Exception e)
			{
			System.out.println("user is not created");
		}
		finally {
		
		
			//close the connection
		con.close();
		}	
	}

}
