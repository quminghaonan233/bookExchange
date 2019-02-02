package software.nju.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.mapper.TradeCancelMapper;
import software.nju.edu.mapper.TradeMapper;



@Controller
public class messageController {
	@Autowired
	private TradeMapper tradeMapper;
	private TradeCancelMapper tradeCancelMapper;
	
	@RequestMapping("/myMessage")
	public String myMessage(String uId, Model model){
		System.out.println(uId);
//		List<Trade> trade = tradeMapper.getAllTradesByUserId(Integer.valueOf(uId));
//		List<TradeCancel> tradeCancel = tradeCancelMapper.getAllTradeCancelByUserId(Integer.valueOf(uId));
//		model.addAttribute(trade);
//		model.addAttribute(tradeCancel);
	    return "message";
	}
}
