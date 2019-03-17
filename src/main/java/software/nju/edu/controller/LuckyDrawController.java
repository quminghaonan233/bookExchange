package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class LuckyDrawController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/luckyDraw")
	public String luckyDraw(String uId, Model model) {
		
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/luckyDraw";
	}

}
