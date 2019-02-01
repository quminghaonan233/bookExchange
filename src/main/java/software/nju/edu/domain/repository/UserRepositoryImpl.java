package software.nju.edu.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import software.nju.edu.domain.entity.User;

@Repository
public class UserRepositoryImpl {
	
	private static int uuid = createUuid();
	
	private static final ConcurrentMap<Integer, User> userConcurrentMap = new ConcurrentHashMap<Integer, User>();
	
	
	public User saveOrUpdateUser(User user) {
		int uid = user.getuId();
		if (uid == 0) {
			uid = uuid;
		}
		this.userConcurrentMap.put(uid, user);
		return user;
	}
	
	public void deleteUser(int uid) {
		this.userConcurrentMap.remove(uid);
		
	}
	
	public User getUserById(int uid) {
		return this.userConcurrentMap.get(uid);
		
	}
	
	public List<User> getUserList() {
		return new ArrayList<User> (this.userConcurrentMap.values());
	}
	
	public static int createUuid() {
		// create unique uid
		return 1000;
	}
	

}
