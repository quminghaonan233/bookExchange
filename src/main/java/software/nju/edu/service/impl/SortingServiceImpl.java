package software.nju.edu.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.SortingService;

@Service
public class SortingServiceImpl implements SortingService {

	@Autowired
	BookServiceImpl bookService;
	
	
	/**
	 * 按价格升序
	 * @param bookList
	 * @return
	 */
	@Override
	public List<Book> sortedByPriceASC(List<Book> bookList) {
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
	
	/**
	 * 按价格降序
	 * @param bookList
	 * @return
	 */
	public List<Book> sortedByPriceDESC(List<Book> bookList) {
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
	public List<Book> sortedByCreditDESC(List<Book> bookList) {
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
	public List<Book> sortedByTimeASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				Date d1 = b1.getFinalUpdateTime();
				Date d2 = b2.getFinalUpdateTime();
				return d1.compareTo(d2);
			}
		});
		return bookList;
		
	}
	
	@Override
	public List<Book> sortedByTimeDESC(List<Book> bookList) {
		// TODO Auto-generated method stub
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				Date d1 = b1.getFinalUpdateTime();
				Date d2 = b2.getFinalUpdateTime();
				return d1.compareTo(d2);
			}
		});
		return bookList;
		
	}

	@Override
	public List<Book> sortedByHotIndexASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByHotIndexDESC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByClicksASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByClicksDESC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByViewsASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByViewsDESC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByClickThroughRateASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByClickThroughRateDESC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortedByCreditASC(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}
}