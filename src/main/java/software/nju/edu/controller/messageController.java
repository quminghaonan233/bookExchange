package software.nju.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class messageController {
	
	
	@RequestMapping("/myMessage")
	public String hello(String uId){
	    return "message";
	}
}
