package software.nju.edu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;

import software.nju.edu.bean.LoginMessage;

@Controller
public class loginController {
	
    @GetMapping("/login")
    public String form(Model model) {
        model.addAttribute("LoginMessage",new LoginMessage());
        return "login";
    }
	
    @PostMapping("/loginValidate")
    public String postForm(@ModelAttribute LoginMessage lm,BindingResult bindingresult, Model model) {

//        Context context = new Context();
		String userName = lm.getUserName();
		//TODO 用户鉴权
		System.out.println(userName);
		model.addAttribute("message", userName);
        return "index";
    }
    
}
