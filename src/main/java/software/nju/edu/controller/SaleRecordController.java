package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Trade;
import software.nju.edu.mapper.TradeMapper;

@Controller
public class SaleRecordController {
	@Autowired
	private TradeMapper tradeMapper;

	@RequestMapping("/mySaleRecord")
	public String myMessage(String uId, Model model) {
		List<Trade> saleList = tradeMapper.getAllTradesBySellerId(Integer.valueOf(uId));
		model.addAttribute("saleList", saleList);
		return "mySaleRecord";
	}
	
}
