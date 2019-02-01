package software.nju.edu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.nju.edu.domain.entity.User;




@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/uId")
	public User getUser(@PathVariable("uId") int uId) {
		return new User(uId, "testname", 1000, 1000);
	}

}
