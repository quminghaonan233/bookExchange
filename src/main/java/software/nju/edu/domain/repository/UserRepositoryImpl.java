package software.nju.edu.domain.repository;

import java.util.List;

import software.nju.edu.domain.entity.User;

@Repository
public class UserRepositoryImpl {
	
	private static String uuid = createUuid();
	
	private final ConcurrentMap<String, User> userConcurrentMap =
			new ConcurrentMap<String, User>();
	
	
	public User saveOrUpdateUser(User user) {
		String uid = user.getUid();
		if (uid == null) {
			uid = uuid;
		}
		this.userConcurrentMap.put(uid, user);
		return user;
	}
	
	public void deleteUser(String uid) {
		this.userConcurrentMap.remove(uid);
		
	}
	
	public User getUserById(String uid) {
		return this.userConcurrentMap.get(uid);
		
	}
	
	public List<User> getUserList() {
		return new ArrayList<User> (this.userConcurrentMap.values());
	}
	
	public static String createUuid() {
		// create unique uid
		return "";
	}
	

}
