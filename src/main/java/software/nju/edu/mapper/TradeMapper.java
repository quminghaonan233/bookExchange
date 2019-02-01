package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.Trade;

public interface TradeMapper {
	
	@Select("SELECT * FROM trade")
	List<Trade> getAllTrades();
	
	@Insert("INSERT INTO trade(tId, buyer, bId, start, end, sendTo, status) "
			+ "VALUES (#{tId}, #{buyer}, #{bId}, #{start}, #{end}, #{sendTo}, #{status})")
	void addNewTrade();
	
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
