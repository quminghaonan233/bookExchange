package software.nju.edu.domain.entity;

import java.io.Serializable;

public class WebData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int bId;
	
	private int clicks;
	
	private int views;
	
	private float clickThroughRate;
	
	private float hotIndex;
	
	public WebData() {
		
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public float getClickThroughRate() {
		return clickThroughRate;
	}

	public void setClickThroughRate(float clickThroughRate) {
		this.clickThroughRate = clickThroughRate;
	}

	public float getHotIndex() {
		return hotIndex;
	}

	public void setHotIndex(float hotIndex) {
		this.hotIndex = hotIndex;
	}
	
	public float calcClickThroughRate() {
		if (views == 0)
			return 0;
		else
			return (float)clicks/views;
	}
	
	public float calcHotIndex(float b) {
		if (views == 0)
			return 0;
		else
			return (float)(1 + b * b) * clicks * views / (b * b * clicks + views);
	}
	
	
	

}
