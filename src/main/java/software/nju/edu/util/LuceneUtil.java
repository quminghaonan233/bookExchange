package software.nju.edu.util;

public class LuceneUtil {
	
	private String lucene_index = "";
	
	public LuceneUtil() {
		setLuceneIndexPath();
	}
	
	public void setLuceneIndexPath() {
		String type = new SystemUtil().getSystemType();
		if (type.equals("Windows"))
			this.lucene_index = "C:/Lucene/LuceneIndex";
		else
			this.lucene_index = "/Users/huanghj/Desktop/LuceneIndex";
	}
	
	public String getLuceneIndex() {
		return lucene_index;
	}

}
