package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;


public class ReadDataFromSQL_DB {

	public static void main(String[] args) throws SQLException {
		OracleDriver driverRef = new OracleDriver();
		DriverManager.registerDriver(driverRef);
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		Statement stat = con.createStatement();
		String query="select * from DEPT";
		
		ResultSet result = stat.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getInt(1)+result.getString(2)+"\t"+result.getString(3));
			
		}
		con.close();
	}

}
