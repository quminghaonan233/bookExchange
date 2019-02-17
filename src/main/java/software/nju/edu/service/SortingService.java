package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface SortingService {
	
	List<Book> sortedByHotIndexASC(List<Book> bookList);
	
	List<Book> sortedByHotIndexDESC(List<Book> bookList);
	
	List<Book> sortedByClicksASC(List<Book> bookList);
	
	List<Book> sortedByClicksDESC(List<Book> bookList);
	
	List<Book> sortedByViewsASC(List<Book> bookList);
	
	List<Book> sortedByViewsDESC(List<Book> bookList);
	
	List<Book> sortedByClickThroughRateASC(List<Book> bookList);
	
	List<Book> sortedByClickThroughRateDESC(List<Book> bookList);
	
	List<Book> sortedByPriceASC(List<Book> bookList);
	
	List<Book> sortedByPriceDESC(List<Book> bookList);
	
	List<Book> sortedByCreditASC(List<Book> bookList);
	
	List<Book> sortedByCreditDESC(List<Book> bookList);
	
	List<Book> sortedByTimeASC(List<Book> bookList);
	
	List<Book> sortedByTimeDESC(List<Book> bookList);

}
