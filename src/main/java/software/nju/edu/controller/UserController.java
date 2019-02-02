package software.nju.edu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/user")
	public String getUser() {
		return "User managed center";
	}
	
	@RequestMapping("/user/{uId}")
	public String getUser(@PathVariable int uId) {
		return "uId = " + uId;
	}
	
	@RequestMapping("/")
	public String getMe() {
		return "";
	}

}
