package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.WebData;

public interface WebDataMapper {
	
	@Select("SELECT * FROM web_data")
	@Results({
		@Result(property = "clickThroughRate", column = "click_throught_rate"),
		@Result(property = "hotIndex", column = "hot_index")
	})
	List<WebData> getAllWebData();
	
	@Select("SELECT * FROM web_data WHERE bId = #{bId}")
	@Results({
		@Result(property = "clickThroughRate", column = "click_through_rate"),
		@Result(property = "hotIndex", column = "hot_index")
	})
	WebData getWebDataByBookId(int bId);
	
	@Select("SELECT COUNT(*) FROM web_data WHERE bId = #{bId}")
	int getWebDataCountByBookId(int bId);
	
	@Insert("INSERT INTO web_data(bId) VALUES (#{bId})")
	void addWebData(int bId);
	
	@Update("UPDATE web_data SET views = views + 1 WHERE bId = #{bId}")
	void updateViews(int bId);
	
	@Update("UPDATE web_data SET clicks = clicks + 1 WHERE bId = #{bId}")
	void updateClicks(int bId);
	
	@Update("UPDATE web_data SET click_through_rate = #{clickThroughRate}, hot_index = #{hotIndex} WHERE bId = #{bId}")
	void updateWebData(WebData webData);

	@Delete("DELETE FROM web_data WHERE bId=#{bId}")
	void deletebId(int bId);
}
