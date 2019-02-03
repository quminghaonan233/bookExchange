package software.nju.edu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.SearchEngineOptimizationService;
import software.nju.edu.util.IndexCreaterUtil;
import software.nju.edu.util.IndexSearcherUtil;

@Service
public class SearchEngineOptimizationServiceImpl implements SearchEngineOptimizationService {
	
	//private static Searcher searcher = null;
	//private static Analyzer analyzer = null;
	//private int maxBufferedDocs = 100;

	public SearchEngineOptimizationServiceImpl() {
		
	}
	
	public List<Book> start(List<Book> bookList, String key) throws Exception {
		
		IndexCreaterUtil creater = new IndexCreaterUtil();
		
		creater.createIndex(bookList);
		
		IndexSearcherUtil searcher = new IndexSearcherUtil();
		
		List<Book> queryResultBookList = searcher.indexSearch(key);
		
		return queryResultBookList;
		
	}

	
}
