package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface SearchEngineOptimizationService {
	
	public List<Book> start(List<Book> bookList, String key) throws Exception;

}
