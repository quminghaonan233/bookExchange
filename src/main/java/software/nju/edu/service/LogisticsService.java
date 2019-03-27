package software.nju.edu.service;

import software.nju.edu.domain.entity.LogisticsInfo;

public interface LogisticsService {
	void addLogistics(int tId,String lName,String lNum);
	LogisticsInfo queryLogistics(int tId);
}
