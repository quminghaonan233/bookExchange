package software.nju.edu.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class LogisticsComapyInfo {
	private String lcId;
	private String lcName;
	public LogisticsComapyInfo() {
		
	}
	public LogisticsComapyInfo(String lcId,String lcName) {
		this.lcId = lcId;
		this.lcName = lcName;
	}
	public String getLcId() {
		return lcId;
	}
	public void setLcId(String lcId) {
		this.lcId = lcId;
	}
	public String getLcName() {
		return lcName;
	}
	public void setLcName(String lcName) {
		this.lcName = lcName;
	}
	
	public List<LogisticsComapyInfo> getAllLc(){
		List<LogisticsComapyInfo>  lcList = new ArrayList<LogisticsComapyInfo>();
		for(LogisticsCompany lc:LogisticsCompany.values()) {
			lcList.add(new LogisticsComapyInfo(lc.getType(), lc.getName()));
		}
		return lcList;
	}
}
