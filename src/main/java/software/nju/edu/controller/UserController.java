package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.serviceimpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	/**
	 * myProfile page is only open for user self.
	 * @param uId
	 * @param model
	 * @return
	 */
	@RequestMapping("/myProfile")
	public String myProfile(String uId, Model model) {
		
		model.addAttribute("user", userService.getUserById(Integer.valueOf(uId)));
		return "myProfile";
	}
	
	/**
	 * user page can be seen by anyone.
	 * @param uId
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/{uId}")
	public String getUserById(@PathVariable String uId, Model model) {
		
		model.addAttribute("user", userService.getUserById(Integer.valueOf(uId)));
		return "user";
	}

}
