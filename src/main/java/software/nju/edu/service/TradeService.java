package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Trade;

public interface TradeService {
	
	void submitTrade(Trade trade);
	
	void updateTradeStatus(int tId, int status);
	
	List<Trade> getAllTradesByBuyerId(int uId);
	
	List<Trade> getAllTradesBySellerId(int uId);

}
