package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import software.nju.edu.domain.entity.User;

public interface UserMapper {
	
	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "uId", column = "uId"),
		@Result(property = "userName", column = "userName")
	})
	List<User> getAllUsers();

}
