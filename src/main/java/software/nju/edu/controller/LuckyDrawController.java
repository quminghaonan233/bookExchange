package software.nju.edu.controller;

import java.util.Random;

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
		double[] probArray = {0.2, 0.3, 0.4, 0.09, 0.01};
		int[] prizeArray = {20, 50, 100, 200, 1000};
		
		model.addAttribute("probArray", probArray);
		model.addAttribute("prizeArray", prizeArray);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/luckyDraw";
	}
	
	@GetMapping("/luckyDrawResult")
	public String luckyDrawResult(String uId, Model model) {
		double[] prob = {0.2, 0.3, 0.4, 0.09, 0.01};
		int[] prize = {20, 50, 100, 200, 1000};
		int prizeResult = randomDraw(prob, prize);
		// 积分扣除
		int cut = 100;
		int lastScore = userService.getScoreById(Integer.valueOf(uId));
		if (userService.getScoreById(Integer.parseInt(uId)) >= 100)
		    userService.cutScoreById(Integer.parseInt(uId), cut);
		else {
			prizeResult = 0;
		}
		// 积分增加
		userService.addScoreById(Integer.parseInt(uId), prizeResult);
		model.addAttribute("lastScore", lastScore);
		model.addAttribute("prizeResult", prizeResult);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/luckyDrawResult";
		
	}
	
	public int randomDraw(double[] prob, int[] prize) {
		Random rand = new Random();
		int result = 0;
		int a = rand.nextInt(100);
		int b = ((a<20)==true?1:0) 
				+ ((a<50)==true?1:0)
				+((a<90)==true?1:0)
				+((a<99)==true?1:0)
				+((a<100)==true?1:0);
		System.out.println(a);
		switch(b) {
		case 5:
			result = prize[0];
			break;
		case 4:
			result = prize[1];
			break;
		case 3:
			result = prize[2];
			break;
		case 2:
			result = prize[3];
			break;
		case 1:
			result = prize[4];
			break;
		
		}
		return result;
	}

}
