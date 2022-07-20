package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UnitTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Driver driverref = new Driver();
			
			DriverManager.registerDriver(driverref);
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36_b1", "root", "root");
			
			Statement stat = conn.createStatement();
			
			String query = "select * from students_inf;";
			ResultSet rset = stat.executeQuery(query);
			while(rset.next()) {
				System.out.println(rset.getString(1) + "\t" + rset.getString(2) + "\t" + rset.getString(3) + "\t" +rset.getString(4));
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception handled");
		}
		finally {
			conn.close();
			System.out.println("Database connectivity closed");
		}

	}

}
