package software.nju.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.WebData;
import software.nju.edu.mapper.WebDataMapper;
import software.nju.edu.service.WebDataService;

public class WebDataServiceImpl implements WebDataService {

	@Autowired
	WebDataMapper webDataMapper;
	
	@Override
	public void updateBookViews(int bId) {
		webDataMapper.updateViews(bId);
	}

	@Override
	public void updateBookClicks(int bId) {
		webDataMapper.updateClicks(bId);
	}

	@Override
	public WebData getWebDataByBookId(int bId) {
		return webDataMapper.getWebDataByBookId(bId);
	}

}
