package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.TradeCancel;

public interface TradeCancelMapper {
	
	@Select("SELECT * FROM trade_cancel")
	List<TradeCancel> getAllTradeCancel();
	
	@Select("SELECT * FROM trade_cancel WHERE sourceId = #{uId}")
	List<TradeCancel> getAllTradeCancelBySourceId(int uId);
	
	@Select("SELECT * FROM trade_cancel WHERE targetId = #{uId}")
	List<TradeCancel> getAllTradeCancelByTargetId(int uId);
	
	@Insert("INSERT INTO trade_cancel("
			+ "tcId, tId, sourceId, sourceName, targetId, targetName, "
			+ "cancelDescription, cancelStatus, "
			+ "tradeDescription, tradeStatus) "
			+ "VALUES ("
			+ "#{tcId}, #{tId}, #{sourceId}, #{sourceName}, #{targetId}, #{targetName}, "
			+ "#{cancelDescription}, #{cancelStatus}, "
			+ "#{tradeDescription}, #{tradeStatus}"
			+ ")")
	void addNewTradeCancel(TradeCancel tradeCancel);
	
	@Update("UPDATE trade_cancel SET cancelStatus = 0 WHERE tcId = #{tcId}")
	void updateCancelStatusAsApplicationWaitng(int tcId);
	
	@Update("UPDATE trade_cancel SET cancelStatus = 1 WHERE tcId = #{tcId}")
	void updateCancelStatusAsApplicationSuccess(int tcId);
	
	@Update("UPDATE trade_cancel SET cancelStatus = 2 WHERE tcId = #{tcId}")
	void updateCancelStatusAsApplicationRefused(int tcId);
	
	@Delete("DELETE FROM trade_cancel WHERE tcId = #{tcId}")
	void deleteTradeCancel(int tcId);
	
}
