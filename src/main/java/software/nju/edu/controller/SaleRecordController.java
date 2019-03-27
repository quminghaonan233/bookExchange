package software.nju.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import software.nju.edu.bean.LogisticsData;
import software.nju.edu.domain.entity.LogisticsInfo;
import software.nju.edu.domain.entity.Trade;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.LogisticsServiceImpl;
import software.nju.edu.service.impl.TradeServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.util.LogisticsQueryUtil;

@Controller
public class SaleRecordController {
	@Autowired
	private TradeServiceImpl tradeService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LogisticsServiceImpl logisticsService;
	@Autowired
	private BookServiceImpl BookService;

	@RequestMapping("/mySaleRecord")
	public String mySaleRecord(String uId, Model model) {
		List<Trade> saleList = tradeService.getAllTradesBySellerId(Integer.valueOf(uId));
		List<LogisticsInfo> buyList = new ArrayList<LogisticsInfo>();
		for(Trade t:saleList) {
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
		model.addAttribute("saleList", buyList);
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
