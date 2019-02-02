package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.User;
import software.nju.edu.serviceimpl.bookServiceImpl;

@Controller
public class indexController {
	
	
	@Autowired
	private bookServiceImpl bookService;
	
	@RequestMapping("/index")
	public String hello(@ModelAttribute User user,Model model){
		List<Book> list = bookService.findHotBookList();
		model.addAttribute("hotBookList",list);
	    return "index";
	}

}
