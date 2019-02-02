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
	@RequestMapping("/")
	public String toLogin(Model model){
	    return "redirect:/login";
	}
	
	@RequestMapping("/index")
	public String hello(@ModelAttribute User user,Model model){
		List<Book> list = bookService.findHotBookList();
		model.addAttribute("hotBookList",list);
		model.addAttribute("user",user);
		System.out.println(model.toString());
	    return "index";
	}
	
	@RequestMapping("/myBook")
	public String myBook(String uId,Model model){
//		List<Book> list = bookService.findHotBookList();
//		model.addAttribute("hotBookList",list);
		System.out.println(model.toString());
		System.out.println(uId);
	    return "myBook";
	}

}
