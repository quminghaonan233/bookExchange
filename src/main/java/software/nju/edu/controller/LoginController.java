package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import software.nju.edu.bean.LoginMessage;
import software.nju.edu.domain.entity.User;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserServiceImpl userService;
	
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