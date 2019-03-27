package software.nju.edu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;

import software.nju.edu.bean.LoginMessage;
import software.nju.edu.bean.ModifyPassword;
import software.nju.edu.bean.RegisterMessage;
import software.nju.edu.domain.entity.User;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.util.TokenUtil;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/")
	public String toLogin(Model model){
	    return "redirect:/login";
	}
	
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
			return "redirect:/index?uId="+u.getuId();
		}
		else {
			redir.addFlashAttribute("failError","用户名或密码错误");
			return "redirect:/login";
		}
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    
    @GetMapping("/registerResult")
    public String registerResult(@ModelAttribute RegisterMessage lm,BindingResult bindingresult,RedirectAttributes redir) {

		String userName = lm.getUserName();
		String passwd = lm.getPassword();
		
		if(userService.isUserNameDup(userName)) {
			redir.addFlashAttribute("failError","用户名重复");
			return "redirect:/register";
		}
		else {
			userService.createUser(userName, passwd);
			return "redirect:/login";

		}
    }
    
    @PostMapping("/modifyPassword")
    @ResponseBody
    public void loginAjax(@RequestBody ModifyPassword modifyMessage, HttpServletResponse resp) {
    	JSONObject jsonObject = new JSONObject();
    	if(userService.validateUserById(modifyMessage.getUserId(), modifyMessage.getPassword())) {
    		userService.updatePassword(modifyMessage.getUserId(),modifyMessage.getNewPassword());
    		jsonObject.put("success", "1");
    	}
    	else {
            jsonObject.put("failError","原密码错误");
    	}
    	
    	


        resp.setContentType("text/html;charset=UTF-8");
        try {
			resp.getWriter().println(jsonObject.toJSONString());
	        resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

    }
    
}
