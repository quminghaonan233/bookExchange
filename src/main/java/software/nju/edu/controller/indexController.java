package software.nju.edu.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import software.nju.edu.bean.UserInfo;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.serviceimpl.bookServiceImpl;

@RestController
public class indexController {
	
	@RequestMapping("/index")
	public ModelAndView hello(Model model){
		ModelAndView mav = new ModelAndView("index");
		bookServiceImpl bookService = new bookServiceImpl();
		List<Book> list = bookService.findHotBookList();
		model.addAttribute("hotBookList",list);
	    return mav;
	}

}
