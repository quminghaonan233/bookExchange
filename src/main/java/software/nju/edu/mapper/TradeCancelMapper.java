package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.association.TradeCancel;

public interface TradeCancelMapper {
	
	@Select("SELECT * FROM trade_cancel")
	List<TradeCancel> getAllTradeCancel();
	
	@Insert("INSERT INTO trade_cancel(tId, initiate, description, status) "
			+ "VALUES (#{tId}, #{initiate}, #{description}, #{status})")
	void addNewTradeCancel();
	
	@Update("UPDATE trade_cancel SET status = 0 WHERE tId = {#tId} AND initiate = {#initiate}")
	void alterStatusAsApplying(TradeCancel tradeCancel);
	
	@Update("UPDATE trade_cancel SET status = 1 WHERE tId = {#tId} AND initiate = {#initiate}")
	void alterStatusAsApplicationSuccess(TradeCancel tradeCancel);
	
	@Update("UPDATE trade_cancel SET status = 2 WHERE tId = {#tId} AND initiate = {#initiate}")
	void alterStatusAsApplicationRefuse(TradeCancel tradeCancel);
	
	@Delete("DELETE FROM trade_cancel WHERE tId = {#tId} AND initiate = {#initiate}")
	void deleteTradeCancel(TradeCancel tradeCancel);
	
}
