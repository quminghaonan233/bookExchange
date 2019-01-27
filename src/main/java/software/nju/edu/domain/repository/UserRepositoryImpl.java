package software.nju.edu.domain.repository;

@Repository
public class UserRepositoryImpl {
	
	private final ConcurrentMap<String, User> userConcurrentMap =
			new ConcurrentMap<String, User>();
	

}
