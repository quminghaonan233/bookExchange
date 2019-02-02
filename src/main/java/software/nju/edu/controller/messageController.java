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
import software.nju.edu.service.userService;
import software.nju.edu.serviceimpl.userServiceImpl;

@Controller
public class messageController {
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private TradeCancelMapper tradeCancelMapper;
	@Autowired
	private userServiceImpl userService;

	@RequestMapping("/myMessage")
	public String myMessage(String uId, Model model) {
		System.out.println(uId);
		List<Trade> sellList = tradeMapper.getAllTradesBySellerId(Integer.valueOf(uId));
		System.out.println("sellList" + sellList.size());
		List<Trade> buyList = tradeMapper.getAllTradesByBuyerId(Integer.valueOf(uId));
		System.out.println("buyList" + buyList.size());

		List<TradeCancel> tradeCancel = tradeCancelMapper.getAllTradeCancelBySourceId(Integer.valueOf(uId));
		System.out.println("tradeCancelSrc" + tradeCancel.size());
		for(int i=0;i<tradeCancel.size();i++) {
			Trade tradeTmp = tradeMapper.getTradeByTradeId(tradeCancel.get(i).gettId());
			tradeCancel.get(i).setBookName(tradeTmp.getBookName());
		}
		
		List<TradeCancel> tradeCancel2 = tradeCancelMapper.getAllTradeCancelByTargetId(Integer.valueOf(uId));
		System.out.println("tradeCancelTar" + tradeCancel2.size());
		for(int i=0;i<tradeCancel2.size();i++) {
			Trade tradeTmp = tradeMapper.getTradeByTradeId(tradeCancel2.get(i).gettId());
			tradeCancel2.get(i).setBookName(tradeTmp.getBookName());
		}

		model.addAttribute("sellList", sellList);
		model.addAttribute("buyList", buyList);
		model.addAttribute("tradeCancelTarList", tradeCancel2);
		model.addAttribute("tradeCancelSrcList", tradeCancel);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "message";
	}
}
