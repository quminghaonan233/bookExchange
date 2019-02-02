package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.serviceimpl.userServiceImpl;


@Controller
public class bookDetailController {
	
	@Autowired
	private userServiceImpl userService;
	@Autowired
	private BookMapper BookMapper;
	
	@RequestMapping("/bookDetail")
	public String hello(String bId,String uId, Model model){
		System.out.println(uId);
		Book book = BookMapper.getBookDetail(Integer.valueOf(bId));
		model.addAttribute(book);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		model.addAttribute("tradeMessage",new TradeMessage());
	    return "bookDetail";
	}
}
