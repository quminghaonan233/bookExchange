package software.nju.edu.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.SortingService;

public class SortingServiceImpl implements SortingService {

	@Autowired
	BookServiceImpl bookService;
	
	@Override
	public List<Book> sortedByPrice(List<Book> bookList) {
		// TODO Auto-generated method stub
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer)b1.getPrice()).compareTo(b2.getPrice());
			}
		});
		
		for (Book b: bookList) {
			System.out.println(b.getbId() + ", " + b.getPrice());
		}
		
		return bookList;
	}

	@Override
	public List<Book> sortedByCredit(List<Book> bookList) {
		// TODO Auto-generated method stub
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> user -> credit
				Integer c1 = bookService.getCreditByBookOwner(b1.getBook_owner());
				// find b2 -> user -> credit
				Integer c2 = bookService.getCreditByBookOwner(b2.getBook_owner());
				return c1.compareTo(c2);
			}
		});
		
		return bookList;
	}

	@Override
	public List<Book> sortedByTimestamp(List<Book> bookList) {
		// TODO Auto-generated method stub
		
		return bookList;
		
	}
	
}