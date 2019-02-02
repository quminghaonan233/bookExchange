package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.User;

public interface UserMapper {
	
	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "uId", column = "uId"),
		@Result(property = "userName", column = "userName")
	})
	List<User> getAllUsers();
	
	@Select("Select * FROM user where userName=#{userName} and passwd=#{passwd}")
	User getUserDetail(String userName,String passwd);

	/**
	 * Select
	 * @return
	 */
	@Select("SELECT * FROM user ORDER BY score DESC")
	List<User> getAllUsersOrderByScoreDesc();
	
	@Select("SELECT * FROM user ORDER BY score ASC")
	List<User> getAllUsersOrderByScoreAsc();
	
	@Select("SELECT * FROM user ORDER BY credit DESC")
	List<User> getAllUsersOrderByCreditDesc();
	
	@Select("SELECT * FROM user ORDER BY credit ASC")
	List<User> getAllUsersOrderByCreditAsc();
	
	/**
	 * Insert
	 * @param user
	 */
	@Insert("INSERT INTO user(userName, passwd, score, credit) VALUES (#{userName}, #{passwd}, #{score}, #{credit})")
	void addNewUser(User user);
	
	@Update("UPDATE user SET userName = #{userName} WHERE uId = #{uId}")
	void updateUserName(User user);
	
	@Update("UPDATE user SET passwd = #{passwd} WHERE uId = #{uId}")
	void updatePasswd(User user);
	
	/**
	 * Update
	 * @param user
	 */
	@Update("UPDATE user SET score = #{score} WHERE uId = #{uId}")
	void updateScore(User user);
	
	@Update("UPDATE user SET credit = #{credit} WHERE uId = #{uId}")
	void updateCredit(User user);
	
	/**
	 * Delete
	 * @param uId
	 */
	@Delete("Delete FROM user WHERE uId = #{uId}")
	void deleteUser(int uId);
	
	
	
}
