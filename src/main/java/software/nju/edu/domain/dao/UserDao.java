package software.nju.edu.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import software.nju.edu.domain.entity.User;

public class UserDao {
	Connection conn;
	private static UserDao userdao;
	
	private UserDao() {
		conn = MySqlConnection.getConnection();	
	}
	
	public static UserDao getInstance() {
		if(userdao == null) {
			userdao = new UserDao();
		}
		return userdao;
	}
	
	public User getUserById(String uId) {
		PreparedStatement pstmt = null;
		User u = null;
		
		String sql = "SELECT * FROM user where uId = ?";
        try {
        	pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uId));
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()){	
		    	u = new User(rs.getInt(uId),rs.getString("userName"),rs.getInt("score"),rs.getInt("credit"));
		    }
		    rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return u;
	}
}
