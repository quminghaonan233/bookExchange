package software.nju.edu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Trade;
import software.nju.edu.domain.entity.TradeCancel;
import software.nju.edu.mapper.TradeCancelMapper;
import software.nju.edu.mapper.TradeMapper;

@Controller
public class messageController {
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private TradeCancelMapper tradeCancelMapper;
	
	@RequestMapping("/myMessage")
	public String myMessage(String uId, Model model){
		System.out.println(uId);
		List<Trade> trade = tradeMapper.getAllTradesByUserId(Integer.valueOf(uId));
		System.out.println("trade Test=" + trade.get(0));
		
		List<TradeCancel> tradeCancel = tradeCancelMapper.getAllTradeCancelByUserId(Integer.valueOf(uId));
		System.out.println("tradeCancel Test=" + tradeCancel.get(0));
		
		model.addAttribute(trade);
		model.addAttribute(tradeCancel);
	    return "message";
	}
}
