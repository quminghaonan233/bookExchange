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
import software.nju.edu.serviceimpl.tradeCancelServiceImpl;
import software.nju.edu.serviceimpl.tradeServiceImpl;
import software.nju.edu.serviceimpl.userServiceImpl;

@Controller
public class messageController {
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private TradeCancelMapper tradeCancelMapper;
	@Autowired
	private userServiceImpl userService;
	@Autowired
	private tradeServiceImpl tradeService;
	@Autowired
	private tradeCancelServiceImpl tradeCancelService;

	@RequestMapping("/myMessage")
	public String myMessage(String uId, Model model) {
//		System.out.println(uId);
		List<Trade> sellList = tradeMapper.getAllTradesBySellerId(Integer.valueOf(uId));
//		System.out.println("sellList" + sellList.size());
		List<Trade> buyList = tradeMapper.getAllTradesByBuyerId(Integer.valueOf(uId));
//		System.out.println("buyList" + buyList.size());

		List<TradeCancel> tradeCancel = tradeCancelMapper.getAllTradeCancelBySourceId(Integer.valueOf(uId));
//		System.out.println("tradeCancelSrc" + tradeCancel.size());
		for(int i=0;i<tradeCancel.size();i++) {
			Trade tradeTmp = tradeMapper.getTradeByTradeId(tradeCancel.get(i).gettId());
			tradeCancel.get(i).setBookName(tradeTmp.getBookName());
		}
		
		List<TradeCancel> tradeCancel2 = tradeCancelMapper.getAllTradeCancelByTargetId(Integer.valueOf(uId));
//		System.out.println("tradeCancelTar" + tradeCancel2.size());
		for(int i=0;i<tradeCancel2.size();i++) {
			Trade tradeTmp = tradeMapper.getTradeByTradeId(tradeCancel2.get(i).gettId());
			tradeCancel2.get(i).setBookName(tradeTmp.getBookName());
		}

		model.addAttribute("userId", uId);
		model.addAttribute("sellList", sellList);
		model.addAttribute("buyList", buyList);
		model.addAttribute("tradeCancelTarList", tradeCancel2);
		model.addAttribute("tradeCancelSrcList", tradeCancel);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		System.out.println(model);
		return "message";
	}
	
	@RequestMapping("/changeTradeStatus")
	public String changeTradeStatus(String tId, String uId, int status, Model model) {
		System.out.println("_____test:" + tId);
		System.out.println("_____test2:" + uId);
		tradeService.updateTradeStatus(Integer.valueOf(tId), status);
		return myMessage(uId, model);
	}

	@RequestMapping("/changeCancelStatus")
	public String changeCancelStatus(String tcId, String uId, int status, Model model) {
		System.out.println("_____test:" + tcId);
		System.out.println("_____test2:" + uId);
		tradeCancelService.updateTradeCancelStatus(Integer.valueOf(tcId), status);
		return myMessage(uId, model);
	}
}
