package software.nju.edu.controller;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping "{/id}"
	public User getUser(@PathVariable("id") String uid) {
		return new User(id, "testname", 1000);
	}

}
