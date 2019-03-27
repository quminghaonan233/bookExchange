package software.nju.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.LogisticsData;
import software.nju.edu.domain.entity.LogisticsInfo;
import software.nju.edu.domain.entity.Trade;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.LogisticsServiceImpl;
import software.nju.edu.service.impl.TradeServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.util.LogisticsQueryUtil;

@Controller
public class PurchaseRecordController {
	@Autowired
	private TradeServiceImpl tradeService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LogisticsServiceImpl logisticsService;
	@Autowired
	private BookServiceImpl BookService;

	@RequestMapping("/myPurchaseRecord")
	public String myPurchaseRecord(String uId, Model model) {
		List<Trade> purchaseList = tradeService.getAllTradesByBuyerId(Integer.valueOf(uId));
		List<LogisticsInfo> buyList = new ArrayList<LogisticsInfo>();
		for(Trade t:purchaseList) {
			LogisticsInfo li;
			if(t.getStatus() == 5) {
				li = logisticsService.queryLogistics(t.gettId());
				List<LogisticsData> liData = LogisticsQueryUtil.jsonHandler(li.getlName(), li.getlNum());
				if(liData == null || liData.size()<=0) {
					li.setIsInfoExist(0);
				}else {
					li.setIsInfoExist(1);
					List<String> dataInfo = new ArrayList<String>();
					for(LogisticsData temp:liData) {
						dataInfo.add(temp.getTime()+":"+temp.getContext());
					}
					li.setlInfo(dataInfo);
				}
			}else {
				li = new LogisticsInfo();
			}
			li.setTrade(t);
			String src = BookService.getBookById(li.getbId()).getImg();
			li.setBook_src(src);
			buyList.add(li);
		}
		model.addAttribute("buyList", buyList);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
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
