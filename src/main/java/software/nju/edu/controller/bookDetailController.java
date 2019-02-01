package software.nju.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class bookDetailController {
	@RequestMapping("/bookDetail")
	public String hello(String bId){
		System.out.println(bId);
	    return "bookDetail";
	}
}
