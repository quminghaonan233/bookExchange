package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface SortingService {
	
	List<Book> sortedByPrice(List<Book> bookList);
	
	List<Book> sortedByCredit(List<Book> bookList);
	
	List<Book> sortedByTimestamp(List<Book> bookList);

}
