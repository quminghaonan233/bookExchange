package software.nju.edu.domain.repository;

import java.util.List;

import software.nju.edu.domain.entity.User;

public interface UserRepository {
	
	User saveOrUpdateUser(User user);
	
	void deleteUser(String uid);
	
	User getUserById(String uid);
	
	List<User> getUserList();

}
