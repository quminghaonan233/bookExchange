package software.nju.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.WebData;
import software.nju.edu.mapper.WebDataMapper;
import software.nju.edu.service.WebDataService;

@Service
public class WebDataServiceImpl implements WebDataService {

	@Autowired
	WebDataMapper webDataMapper;

	@Override
	public void updateBookViews(int bId) {
		if (getWebDataCountByBookId(bId) == 0)
			webDataMapper.addWebData(bId);
		webDataMapper.updateViews(bId);
		updateWebData(bId);
	}

	@Override
	public void updateBookClicks(int bId) {
		if (getWebDataCountByBookId(bId) == 0)
			webDataMapper.addWebData(bId);
		webDataMapper.updateClicks(bId);
		updateWebData(bId);
	}

	@Override
	public WebData getWebDataByBookId(int bId) {
		return webDataMapper.getWebDataByBookId(bId);
	}

	@Override
	public int getWebDataCountByBookId(int bId) {
		return webDataMapper.getWebDataCountByBookId(bId);
	}

	@Override
	public void updateWebData(int bId) {
		WebData webData = webDataMapper.getWebDataByBookId(bId);
		float b = 1;
		float clickThroughRate = webData.calcClickThroughRate();
		float hotIndex = webData.calcHotIndex(b);
		webData.setClickThroughRate(clickThroughRate);
		webData.setHotIndex(hotIndex);
		webDataMapper.updateWebData(webData);

	}

}
