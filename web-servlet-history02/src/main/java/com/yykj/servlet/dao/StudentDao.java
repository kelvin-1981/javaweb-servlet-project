package com.yykj.servlet.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class StudentDao {

	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC"; 
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "hh96n55g";

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean createStudent(String name,int age){
		if(name == null || name.equalsIgnoreCase("")){
			return false;
		}
		if(age <= 0){
			return false;
		}
		
		ComboPooledDataSource source =  new ComboPooledDataSource();
		try {
			source.setDriverClass(DRIVER);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source.setJdbcUrl(URL);
		source.setUser(USER_NAME);
		source.setPassword(PASSWORD);
		
		QueryRunner runner = new QueryRunner(source);
		Object[] params = {name,age};
		int result = 0;
		try {
			result = runner.execute("insert into student(name,age) values (?,?);", params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result > 0 ? true : false;
	}
}
