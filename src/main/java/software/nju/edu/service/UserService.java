package software.nju.edu.service;

import software.nju.edu.domain.entity.User;

public interface UserService {
	
	public User validateUser(String userName,String passwd);
	
	public User getUserById(int uId);
	
	public String getUserName(int uid);
}
