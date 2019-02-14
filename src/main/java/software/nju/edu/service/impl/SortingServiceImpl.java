package software.nju.edu.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.SortingService;

public class SortingServiceImpl implements SortingService {

	@Override
	public void sortedByPrice(List<Book> bookList) {
		// TODO Auto-generated method stub
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer)b1.getPrice()).compareTo(b2.getPrice());
			}
		});
		
		for (Book b: bookList) {
			System.out.println(b.getbId() + ", " + b.getPrice());
		}
		
	}

	@Override
	public void sortedByCredit(List<Book> bookList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortedByTimestamp(List<Book> bookList) {
		// TODO Auto-generated method stub
		
	}
	
}