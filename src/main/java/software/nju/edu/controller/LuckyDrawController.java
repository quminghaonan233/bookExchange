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
		// 100 score once.
		// 20 * 0.1 + 50 * 0.3 + 100 * 0.5 + 200 * 0.09 + 1000 * 0.01 = 
		// 2 + 15 + 50 + 18 + 10 = 97 
		double[] probability = {0.2, 0.3, 0.4, 0.09, 0.01};
		int[] score = {20, 50, 100, 200, 1000};
		
		model.addAttribute("probability", probability);
		model.addAttribute("score", score);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/luckyDraw";
	}

}
