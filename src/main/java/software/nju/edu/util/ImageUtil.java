package software.nju.edu.util;

public class ImageUtil {
	
	private String img_path = "";
	
	public ImageUtil() {
		setBookImagePath();
	}
	
	public void setBookImagePath() {
		String type = new SystemUtil().getSystemType();
		if (type.equals("Windows"))
			this.img_path = "C:/BookExchangeresource/BookImageSet/";
		else if (type.equals("Mac OS"))
			this.img_path = "/Users/huanghj/Test/BookExchangeResource/BookImageSet/";
		else
			this.img_path = "/root/BookExchangeResource/BookImageSet/";
	}
	
	public String getImagePath() {
		return img_path;
	}

}
