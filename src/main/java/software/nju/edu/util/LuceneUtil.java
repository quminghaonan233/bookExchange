package software.nju.edu.util;

public class LuceneUtil {
	
	private String lucene_index = "";
	
	public LuceneUtil() {
		setLuceneIndexPath();
	}
	
	public void setLuceneIndexPath() {
		String type = new SystemUtil().getSystemType();
		if (type.equals("Windows"))
			this.lucene_index = "C:/BookExchangeResource/LuceneIndex/";
		else if (type.equals("Mac OS"))
			this.lucene_index = "/Users/huanghj/Test/BookExchangeResource/LuceneIndex/";
		else
			this.lucene_index = "/root/BookExchangeResource/LuceneIndex/";
	}
	
	public String getLuceneIndex() {
		return lucene_index;
	}

}
