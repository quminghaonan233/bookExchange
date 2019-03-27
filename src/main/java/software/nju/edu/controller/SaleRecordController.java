package software.nju.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import software.nju.edu.domain.entity.Trade;
import software.nju.edu.service.impl.LogisticsServiceImpl;
import software.nju.edu.service.impl.TradeServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class SaleRecordController {
	@Autowired
	private TradeServiceImpl tradeService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LogisticsServiceImpl logisticsService;

	@RequestMapping("/mySaleRecord")
	public String mySaleRecord(String uId, Model model) {
		List<Trade> saleList = tradeService.getAllTradesBySellerId(Integer.valueOf(uId));
		model.addAttribute("saleList", saleList);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		
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
    
    @PostMapping("/logisticsWriter")
    public String postForm(HttpServletRequest request,Model model) {
    	MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		String uId = params.getParameter("uId");
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		
		String tId = params.getParameter("tId");
		String lName = params.getParameter("lName");
		String lNum = params.getParameter("lNum");
		if (lName.equals("") || lNum.equals("")) {
			return "redirect:/mySaleRecord?uId="+uId;
		}
		
		tradeService.updateTradeStatus(Integer.valueOf(tId), 5);
		logisticsService.addLogistics(Integer.parseInt(tId), lName, lNum);
		
		return "redirect:/mySaleRecord?uId="+uId;
    }
	
}
