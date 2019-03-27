package software.nju.edu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import software.nju.edu.domain.entity.LogisticsInfo;

public interface LogisticsMapper {
	@Insert("INSERT INTO logistics(tId,lName,lNum) VALUES (#{tId},#{lName},#{lNum})")
	void addLogistics(@Param("tId")int tId,@Param("lName")String lName,@Param("lNum")String lNum);
	
	@Select("SELECT * FROM logistics WHERE tId = #{tId} limit 1")
	LogisticsInfo queryLogistics(@Param("tId")int tId);
}
