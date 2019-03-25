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
public class PurchaseRecordController {
	@Autowired
	private TradeServiceImpl tradeService;

	@RequestMapping("/myPurchaseRecord")
	public String myPurchaseRecord(String uId, Model model) {
		List<Trade> purchaseList = tradeService.getAllTradesByBuyerId(Integer.valueOf(uId));
		model.addAttribute("buyList", purchaseList);
		return "myPurchaseRecord";
	}
	
	@RequestMapping("/cancelApplication")
	public String cancelApplication(String tId, String uId, Model model) {
		tradeService.updateTradeStatus(Integer.valueOf(tId), 4);
		return "redirect:/myPurchaseRecord?uId="+uId;
	}
	
	@RequestMapping("/purchaseSuccess")
	public String purchaseSuccess(String tId, String uId, Model model) {
		tradeService.updateTradeStatus(Integer.valueOf(tId), 3);
		return "redirect:/myPurchaseRecord?uId="+uId;
	}
	
}
