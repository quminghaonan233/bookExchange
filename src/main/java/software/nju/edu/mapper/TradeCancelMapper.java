package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.TradeCancel;
import software.nju.edu.domain.entity.Trade;

public interface TradeCancelMapper {
	
	@Select("SELECT * FROM trade_cancel")
	List<TradeCancel> getAllTradeCancel();
	
	@Select("SELECT COUNT(tcId) FROM trade_cancel")
	int getTradeCancelId();
	
	@Select("SELECT * FROM trade_cancel WHERE initiate = #{uId}")
	List<TradeCancel> getAllTradeCancelByUserId(int uId);
	
	@Select("SELECT * FROM trade_cancel WHERE tId In \n" + 
			"(\n" + 
			"	SELECT tId FROM trade WHERE bId in \n" + 
			"	(\n" + 
			"		SELECT bId FROM book WHERE book_owner = #{uId}\n" + 
			"	)\n" + 
			")")
	List<TradeCancel> getAllTradeCancelsBySellerId(int uId);
	
	@Insert("INSERT INTO trade_cancel(tId, initiate, description, status) "
			+ "VALUES (#{tId}, #{initiate}, #{description}, #{status})")
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
