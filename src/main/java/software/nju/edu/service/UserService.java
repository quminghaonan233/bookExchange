package software.nju.edu.service;

import software.nju.edu.domain.entity.User;

public interface UserService {
	
	public User validateUser(String userName,String passwd);
	
	public User getUserById(int uId);
	
	public String getUserName(int uid);
	
	public int getScoreById(int uId);
	
	public void cutScoreById(int uId, int cut);
	
	public void setScoreById(int uId, int score);
	
	public void addScoreById(int uId, int add);
	
}
