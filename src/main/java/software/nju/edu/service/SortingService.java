package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface SortingService {
	
	void sortedByPrice(List<Book> bookList);
	
	void sortedByCredit(List<Book> bookList);
	
	void sortedByTimestamp(List<Book> bookList);

}
