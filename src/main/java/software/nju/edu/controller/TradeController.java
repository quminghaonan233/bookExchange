package software.nju.edu.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.Trade;
import software.nju.edu.mapper.TradeMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.TradeServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class TradeController {
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private TradeServiceImpl tradeService;
	
	@Autowired
	private TradeMapper tradeMapper;
	
	@RequestMapping("/tradeSubmit")
	public String hello(String trade_sendTo,String trade_description,String bId,String uId, Model model){
		int buyerId = Integer.parseInt(uId);
		String buyerName =  userService.getUserById(Integer.parseInt(uId)).getUserName();
		Book b = bookService.getBookById(Integer.parseInt(bId));
		int sellerId = b.getBook_owner();
		String sellerName = userService.getUserName(sellerId);
		String bookName = b.getBookName();
		Date start = new Timestamp(System.currentTimeMillis());
		String sendTo = trade_sendTo;
		String description = trade_description;
		int status = 0;
		Trade t = new Trade(buyerId, buyerName, sellerId, sellerName, Integer.parseInt(bId), bookName, start,
				sendTo, description,status);
		tradeService.submitTrade(t);
		
	    return "redirect:/index?uId="+uId;
	}
	
}

