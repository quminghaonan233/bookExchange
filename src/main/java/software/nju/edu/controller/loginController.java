package software.nju.edu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;

import software.nju.edu.bean.LoginMessage;
import software.nju.edu.domain.entity.User;
import software.nju.edu.serviceimpl.userServiceImpl;

@Controller
public class loginController {
	
	
	@Autowired
	private userServiceImpl userService;
	
    @GetMapping("/login")
    public String form(Model model) {
        model.addAttribute("LoginMessage",new LoginMessage());
        return "login";
    }
	
    @PostMapping("/loginValidate")
    public String postForm(@ModelAttribute LoginMessage lm,BindingResult bindingresult,RedirectAttributes redir) {

		String userName = lm.getUserName();
		String passwd = lm.getPassword();
		
		User u = userService.validateUser(userName, passwd);
		if(u != null) {
			return "redirect:/index?uId="+ u.getuId();
		}
		else {
			redir.addFlashAttribute("failError","用户名或密码错误");
			return "redirect:/login";
		}
    }
    
}
