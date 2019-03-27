package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.User;

public interface UserMapper {
	
	@Select("SELECT userName FROM user WHERE uId = #{uId}")
	String getUserNameByUserId(int uId);
	
	@Select("SELECT * FROM user")
	List<User> getAllUsers();
	
	@Select("Select * FROM user where userName=#{userName} and passwd=#{passwd}")
	User getUserDetail(@Param("userName")String userName,@Param("passwd")String passwd);
	
	@Select("Select * FROM user where userName=#{userName}")
	User getUserByName(@Param("userName")String userName);
	
	@Select("Select * FROM user where uId=#{uId}")
	User getUserById(int uId);
	
	@Select("Select score FROM user where uId=#{uId}")
	int getScoreById(int uId);

	
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
	
	@Update("UPDATE user SET score = score - #{cut} WHERE uId = #{uId}")
	void cutScoreById(int uId, int cut);
	
	@Update("UPDATE user SET score = #{score} WHERE uId = #{uId}")
	void setScoreById(int uId, int score);
	
	@Update("UPDATE user SET score = score + #{add} WHERE uId = #{uId}")
	void addScoreById(int uId, int add);
	
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
	
	@Update("UPDATE user SET credit = #{credit} WHERE uId = #{uId}")
	void updateUserCredit(@Param("uId")int uId,@Param("credit")int credit);
	
	@Select("SELECT credit FROM user WHERE uId = #{uId}")
	int getUserCredit(@Param("uId")int uId);
	
}
