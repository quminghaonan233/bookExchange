package software.nju.edu.service;

import software.nju.edu.domain.entity.User;

public interface userService {
	public User validateUser(String userName,String passwd);
}
