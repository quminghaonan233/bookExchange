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
	
	@Update("UPDATE trade_cancel SET status = 0 WHERE tId = #{tId} AND initiate = #{initiate}")
	void alterStatusAsApplying(TradeCancel tradeCancel);
	
	@Update("UPDATE trade_cancel SET status = 1 WHERE tId = #{tId} AND initiate = #{initiate}")
	void alterStatusAsApplicationSuccess(TradeCancel tradeCancel);
	
	@Update("UPDATE trade_cancel SET status = 2 WHERE tId = #{tId} AND initiate = #{initiate}")
	void alterStatusAsApplicationRefuse(TradeCancel tradeCancel);
	
	@Delete("DELETE FROM trade_cancel WHERE tId = #{tId} AND initiate = #{initiate}")
	void deleteTradeCancel(TradeCancel tradeCancel);
	
}
