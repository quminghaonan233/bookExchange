package software.nju.edu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import software.nju.edu.bean.UserInfo;

@RestController
public class indexController {
	
	@RequestMapping("/index")
	public ModelAndView hello(UserInfo u){
		ModelAndView mav = new ModelAndView("index");
	    return mav;
	}

}
