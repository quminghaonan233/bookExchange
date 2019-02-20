package software.nju.edu.service;

import software.nju.edu.domain.entity.WebData;

public interface WebDataService {
	
	void updateBookViews(int bId);
	
	void updateBookClicks(int bId);
	
	void updateWebData(int bId);
	
	int getWebDataCountByBookId(int bId);
	
	WebData getWebDataByBookId(int bId);

}
