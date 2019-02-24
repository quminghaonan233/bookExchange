package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface SortingService {
	
	List<Book> sortedByHotIndexAsc(List<Book> bookList);
	
	List<Book> sortedByHotIndexDesc(List<Book> bookList);
	
	List<Book> sortedByClickThroughRateAsc(List<Book> bookList);
	
	List<Book> sortedByClickThroughRateDesc(List<Book> bookList);
	
	List<Book> sortedByClicksAsc(List<Book> bookList);
	
	List<Book> sortedByClicksDesc(List<Book> bookList);
	
	List<Book> sortedByViewsAsc(List<Book> bookList);
	
	List<Book> sortedByViewsDesc(List<Book> bookList);
	
	List<Book> sortedByPriceAsc(List<Book> bookList);
	
	List<Book> sortedByPriceDesc(List<Book> bookList);
	
	List<Book> sortedByCreditAsc(List<Book> bookList);
	
	List<Book> sortedByCreditDesc(List<Book> bookList);
	
	List<Book> sortedByTimeAsc(List<Book> bookList);
	
	List<Book> sortedByTimeDesc(List<Book> bookList);

}
