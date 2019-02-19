package software.nju.edu.mapper;

import org.apache.ibatis.annotations.Insert;

public interface WebDataMapper {
	
	@Insert("INSERT INTO web_data(bId) VALUES (#{bId})")
	void addWebData(int bId);
	

}
