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
import software.nju.edu.service.impl.TradeCancelServiceImpl;
import software.nju.edu.service.impl.TradeServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class SaleRecordController {
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private TradeCancelMapper tradeCancelMapper;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private TradeServiceImpl tradeService;
	@Autowired
	private TradeCancelServiceImpl tradeCancelService;

	@RequestMapping("/mySaleRecord")
	public String myMessage(String uId, Model model) {
		
		return "mySaleRecord";
	}
	
}
