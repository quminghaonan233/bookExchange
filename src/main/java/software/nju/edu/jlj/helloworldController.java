package software.nju.edu.jlj;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class helloworldController {
	
	@RequestMapping("/welcome")
	public ModelAndView hello(Model model){
	    return new ModelAndView("welcome","welcomeModel",model);
	}

}
