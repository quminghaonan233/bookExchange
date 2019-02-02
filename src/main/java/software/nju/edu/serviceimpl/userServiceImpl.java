package software.nju.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.User;
import software.nju.edu.mapper.UserMapper;
import software.nju.edu.service.userService;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User validateUser(String userName, String passwd) {
		// TODO Auto-generated method stub
		User u = userMapper.getUserDetail(userName, passwd);
		return u;
	}
	
	@Override
	public User getUserById(int uId) {
		User u = userMapper.getUserById(uId);
		return u;
	}
}
