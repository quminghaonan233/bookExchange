package software.nju.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.mapper.LogisticsMapper;
import software.nju.edu.service.LogisticsService;


@Service
public class LogisticsServiceImpl implements LogisticsService{
	
	@Autowired
	private LogisticsMapper logisticsMapper;
	
	public void addLogistics(int tId,String lName,String lNum) {
		logisticsMapper.addLogistics(tId, lName, lNum);
	}
}
