package software.nju.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private static Connection conn = null;
	private static final String URL = "jdbc:mysql://106";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "test";
	private static final String PASSWORD = "test";
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);// 找到 jdbc.Driver 驱动
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 加载驱动
			
		} catch (ClassNotFoundException e) { // 未找到驱动
			e.printStackTrace();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll() {
		
	}
	


}
