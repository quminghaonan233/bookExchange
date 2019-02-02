package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.Trade_;

public interface Trade_Mapper {
	
	@Select("SELECT * FROM trade")
	List<Trade_> getAllTrades();
	
	@Select("SELECT * FROM trade WHERE buyer = #{buyer}")
	List<Trade_> getAllTradesByUserId(int buyer);
	
	@Insert("INSERT INTO trade(tId, buyer, bId, start, end, sendTo, status) "
			+ "VALUES (#{tId}, #{buyer}, #{bId}, #{start}, #{end}, #{sendTo}, #{status})")
	void addNewTrade(Trade_ trade);
	
	@Select("SELECT * FROM trade WHERE bId In (SELECT bId FROM book WHERE book_owner = #{book_owner})")
	List<Trade_> getAllTradesBySellerId(int book_owner);
	
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
