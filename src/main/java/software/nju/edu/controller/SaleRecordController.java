package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.domain.entity.Trade;
import software.nju.edu.mapper.TradeMapper;
import software.nju.edu.service.impl.TradeServiceImpl;

@Controller
public class SaleRecordController {
	@Autowired
	private TradeServiceImpl tradeService;

	@RequestMapping("/mySaleRecord")
	public String mySaleRecord(String uId, Model model) {
		List<Trade> saleList = tradeService.getAllTradesBySellerId(Integer.valueOf(uId));
		model.addAttribute("saleList", saleList);
		return "mySaleRecord";
	}
	
	@RequestMapping("/approveToSell")
	public String approveToSell(String tId, String uId, Model model) {
		tradeService.updateTradeStatus(Integer.valueOf(tId), 1);
		return "redirect:/mySaleRecord?uId="+uId;
	}
	
	@RequestMapping("/refuseToSell")
	public String refuseToSell(String tId, String uId, Model model) {
		tradeService.updateTradeStatus(Integer.valueOf(tId), 2);
		return "redirect:/mySaleRecord?uId="+uId;
	}
	
}
