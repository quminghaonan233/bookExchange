package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class FlashSaleController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/flashSale")
	public String flashSale(String uId, Model model) {
		
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/flashSale";
	}
	

}
