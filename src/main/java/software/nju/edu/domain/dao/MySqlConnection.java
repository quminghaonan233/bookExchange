package software.nju.edu.domain.dao;

import java.sql.*;

import software.nju.edu.domain.entity.User;

public class MySqlConnection {
		
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://106.15.224.136:3306/book_exchange";

    static final String USER = "root";
    static final String PASS = "123456";
    
    private static Connection conn = null;
    
	private MySqlConnection() {
		
	}
    public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("getConnection class not found error");
		} catch (SQLException e) {
			System.out.println("getConnection sqlException");
		}
    	return conn;
    }
    
    
}
