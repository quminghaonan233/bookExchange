package software.nju.edu.service;

import software.nju.edu.domain.entity.TradeCancel;

public interface TradeCancelService {
	
	void submitTradeCancel(TradeCancel tradeCancel);
	
	void updateTradeCancelStatus(int tcId, int cancelStatus);

}
