package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.Trade;

public interface TradeMapper {
	
	@Select("SELECT * FROM trade")
	List<Trade> getAllTrades();
	
	@Select("SELECT * FROM trade WHERE tId = #{tId}")
	Trade getTradeByTradeId(int tId);
	
	@Select("SELECT * FROM trade WHERE buyerId = #{buyerId}")
	List<Trade> getAllTradesByBuyerId(int buyerId);
	
	@Select("SELECT * FROM trade WHERE sellerId = #{sellerId}")
	List<Trade> getAllTradesBySellerId(int sellerId);
	
	@Insert("INSERT INTO trade("
			+ "tId, buyerId, buyerName, sellerId, sellerName, bId, bookName, "
			+ "start, end, sendTo, description, status) "
			+ "VALUES ("
			+ "#{tId}, #{buyerId}, #{buyerName}, #{sellerId}, #{sellerName}, #{bId}, #{bookName}, "
			+ "#{start}, #{end}, #{sendTo}, #{description}, #{status}"
			+ ")")
	void addNewTrade(Trade trade);
		
	/**
	 * 4 status for trade status = 0, 1, 2, 3.
	 * @param tId
	 */
	@Update("UPDATE trade SET status = 0 WHERE tId = #{tId}")
	void alterTradeStatusAsApplying(int tId);
	
	@Update("UPDATE trade SET status = 1 WHERE tId = #{tId}")
	void alterTradeStatusAsApplicationSuccess(int tId);
	
	@Update("UPDATE trade SET status = 2 WHERE tId = #{tId}")
	void alterTradeStatusAsApplicationRefuse(int tId);
	
	@Update("UPDATE trade SET status = 3 WHERE tId = #{tId}")
	void alterTradeStatusAsApplicationFinished(int tId);
	
	

}
