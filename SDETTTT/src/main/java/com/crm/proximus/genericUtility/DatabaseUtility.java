package com.crm.proximus.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to connect to database
 * @author Deepak
 *
 */
public class DatabaseUtility {
	
	static Driver d_ref;
	static Connection conn;
	static ResultSet resSet;
	
	/**
	 * this method will connect our program to database
	 * @throws SQLException
	 */
	public void connectToDatabase() throws SQLException{
		try {
			DriverManager.registerDriver(d_ref);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet36_b1", "root", "root");
		}
		catch (Exception e) {
			System.out.println("Handling Exception");
		}
	}
	
	/**
	 * this method will close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
		  conn.close();
		}catch (Exception e) {
		}
	}
	
	/**
	 * This method will execute the Query
	 * @param query
	 * @return ResultSet
	 * @throws Throwable
	 */
	public ResultSet executeSqlQuery(String query) throws Throwable {	
			resSet = conn.createStatement().executeQuery(query);
			return resSet;		
	}

	/**
	 * This method will execute the Update
	 * @param query
	 * @return int
	 * @throws Throwable
	 */
	public int executeSqlUpdate(String query) throws Throwable {
		int result = conn.createStatement().executeUpdate(query);	
		return result;
	}

	/**
	 * This method will execute query based on query and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQueryAndVerify(String query,int columnName,String expData) throws Throwable {
		boolean flag=false;
		resSet=conn.createStatement().executeQuery(query);
		while(resSet.next()) {
			if(resSet.getString(columnName).equals(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expData+"==>data is not verified in the database");
			return flag;
		}
 

	}
}
