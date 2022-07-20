package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		int result = 0;
		try{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36_b1", "root", "root");
		Statement stat = conn.createStatement();
		String query = "insert into students_info (regno, firstname, middlename, lastname) values('9', 'John','Wick', 'h');";
		result = stat.executeUpdate(query);
		}
		finally {
		if(result == 1)
			System.out.println("Entry succesfull");
		else
			System.err.println("Entry failed");
		conn.close();
		System.out.println("Connection closed");
		}
	}

}
