package software.nju.edu.service;

import software.nju.edu.domain.entity.Trade;

public interface tradeService {
	
	void submitTrade(Trade trade);
	
	void updateTradeStatus(int tId, int status);

}
