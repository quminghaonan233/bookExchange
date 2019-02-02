package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.Trade_Mapper;

@Controller
public class tradeController {

	@Autowired
	private Trade_Mapper tradeMapper;
	
	@RequestMapping("/tradeSubmit")
	public String hello(@ModelAttribute TradeMessage tradeMessage, Model model){
	    return "tradeSuccess";
	}
}
