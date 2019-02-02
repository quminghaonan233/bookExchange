package software.nju.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.Trade;
import software.nju.edu.mapper.TradeMapper;
import software.nju.edu.service.tradeService;

public class tradeServiceImpl implements tradeService {

	@Autowired
	private TradeMapper tradeMapper;
	
	@Override
	public void submitTrade(Trade trade) {
		tradeMapper.addNewTrade(trade);	
	}

	@Override
	public void updateTradeStatus(int tId, int status) {
		switch (status) {
		case 0:
			tradeMapper.updateTradeStatusAsApplicationWaiting(tId);
			break;
		case 1:
			tradeMapper.updateTradeStatusAsApplicationSuccess(tId);
			break;
		case 2:
			tradeMapper.updateTradeStatusAsApplicationRefused(tId);
			break;
		case 3:
			tradeMapper.updateTradeStatusAsApplicationFinished(tId);
			break;
		}
		
	}

}
