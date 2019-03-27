package software.nju.edu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LogisticsMapper {
	@Insert("INSERT INTO logistics(tId,lName,lNum) VALUES (#{tId},#{lName},#{lNum})")
	void addLogistics(@Param("tId")int tId,@Param("lName")String lName,@Param("lNum")String lNum);
}
