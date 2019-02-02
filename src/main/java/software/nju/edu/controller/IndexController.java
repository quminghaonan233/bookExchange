package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.User;
import software.nju.edu.serviceimpl.BookServiceImpl;
import software.nju.edu.serviceimpl.UserServiceImpl;

@Controller
public class IndexController {
	
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/")
	public String toLogin(Model model){
	    return "redirect:/login";
	}
	
	@RequestMapping("/index")
	public String hello(String uId,Model model){
		List<Book> list = bookService.findHotBookList();
		model.addAttribute("hotBookList",list);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		System.out.println(model.toString());
	    return "index";
	}
	
	@RequestMapping("/myBook")
	public String myBook(String uId,Model model){
		List<Book> list = bookService.queryMineBooks(Integer.valueOf(uId));
		User u = userService.getUserById(Integer.parseInt(uId));
		model.addAttribute("myBookList",list);
		model.addAttribute("user",u);
	    return "myBook";
	}

}
