package software.nju.edu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.TradeCancel;
import software.nju.edu.mapper.TradeCancelMapper;
import software.nju.edu.service.tradeCancelService;

public class tradeCancelServiceImpl implements tradeCancelService {

	@Autowired
	private TradeCancelMapper tradeCancelMapper;

	@Override
	public void submitTradeCancel(TradeCancel tradeCancel) {
		tradeCancelMapper.addNewTradeCancel(tradeCancel);

	}

	@Override
	public void updateTradeCancelStatus(int tcId, int cancelStatus) {
		switch (cancelStatus) {
		case 0:
			tradeCancelMapper.updateCancelStatusAsApplicationWaitng(tcId);
			break;
		case 1:
			tradeCancelMapper.updateCancelStatusAsApplicationSuccess(tcId);
			break;
		case 2:
			tradeCancelMapper.updateCancelStatusAsApplicationRefused(tcId);
			break;
		}

	}

}
