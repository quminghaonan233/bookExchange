package software.nju.edu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.nju.edu.domain.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/id")
	public User getUser(@PathVariable("id") String uid) {
		return new User(uid, "testname", 1000);
	}

}
