package software.nju.edu.seo;

import java.util.List;
import software.nju.edu.bean.SearchBean;
import software.nju.edu.domain.entity.Book;

public class SEOLogic {
	
	//private static Searcher searcher = null;
	//private static Analyzer analyzer = null;
	private int maxBufferedDocs = 100;

	public SEOLogic() {
		
	}
	
	public List<Book> start(List<Book> bookList, String key) throws Exception {
		
		IndexCreaterProcess creater = new IndexCreaterProcess();
		
		creater.createIndex(bookList);
		
		IndexSearcherProcess searcher = new IndexSearcherProcess();
		
		List<Book> queryResultBookList = searcher.indexSearch(key);
		
		return queryResultBookList;
		
	}

	
}
