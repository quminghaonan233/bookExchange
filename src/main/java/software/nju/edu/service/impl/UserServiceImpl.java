package software.nju.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.User;
import software.nju.edu.mapper.UserMapper;
import software.nju.edu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User validateUser(String userName, String passwd) {
		User u = userMapper.getUserDetail(userName, passwd);
		return u;
	}
	
	public boolean isUserNameDup(String userName) {
		User u = userMapper.getUserByName(userName);
		if(u != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public User getUserById(int uId) {
		User u = userMapper.getUserById(uId);
		return u;
	}

	@Override
	public String getUserName(int uId) {
		String userName = userMapper.getUserNameByUserId(uId);
		return userName;
	}

	@Override
	public int getScoreById(int uId) {
		// TODO Auto-generated method stub
		int score = userMapper.getScoreById(uId);
		return score;
	}

	@Override
	public void cutScoreById(int uId, int cut) {
		userMapper.cutScoreById(uId, cut);
	}

	@Override
	public void setScoreById(int uId, int score) {
		userMapper.setScoreById(uId, score);
	}

	@Override
	public void addScoreById(int uId, int add) {
		userMapper.addScoreById(uId, add);
		
	}
	
}
