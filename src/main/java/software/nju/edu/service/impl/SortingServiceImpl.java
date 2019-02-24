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
	public List<Book> sortedByPriceAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer)b1.getPrice()).compareTo(b2.getPrice());
			}
		});
//		for (Book b: bookList) {
//			System.out.println(b.getbId() + ", " + b.getPrice());
//		}
		return bookList;
	}
	
	/**
	 * 按价格降序
	 * @param bookList
	 * @return
	 */
	@Override
	public List<Book> sortedByPriceDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer)b2.getPrice()).compareTo(b1.getPrice());
			}
		});
		return bookList;
	}

	/**
	 * 按信用升序
	 */
	@Override
	public List<Book> sortedByCreditAsc(List<Book> bookList) {
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
	
	/**
	 * 按信用降序
	 */
	@Override
	public List<Book> sortedByCreditDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> user -> credit
				Integer c1 = bookService.getCreditByBookOwner(b1.getBook_owner());
				// find b2 -> user -> credit
				Integer c2 = bookService.getCreditByBookOwner(b2.getBook_owner());
				return c2.compareTo(c1);
			}
		});
		return bookList;
	}
	
	/**
	 * 按发布时间升序
	 */
	@Override
	public List<Book> sortedByTimeAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				Date d1 = b1.getFinalUpdateTime();
				Date d2 = b2.getFinalUpdateTime();
				return d1.compareTo(d2);
			}
		});
		return bookList;
		
	}
	
	/**
	 * 按发布时间降序
	 */
	@Override
	public List<Book> sortedByTimeDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				Date d1 = b1.getFinalUpdateTime();
				Date d2 = b2.getFinalUpdateTime();
				return d2.compareTo(d1);
			}
		});
		return bookList;
		
	}

	/**
	 * 按热点值升序
	 */
	@Override
	public List<Book> sortedByHotIndexAsc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按热点值降序
	 */
	@Override
	public List<Book> sortedByHotIndexDesc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按点击数升序
	 */
	@Override
	public List<Book> sortedByClicksAsc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按点击数降序
	 */
	@Override
	public List<Book> sortedByClicksDesc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按浏览数升序
	 */
	@Override
	public List<Book> sortedByViewsAsc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按浏览数降序
	 */
	@Override
	public List<Book> sortedByViewsDesc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按点击率升序
	 */
	@Override
	public List<Book> sortedByClickThroughRateAsc(List<Book> bookList) {
		return null;
	}

	/**
	 * 按点击率降序
	 */
	@Override
	public List<Book> sortedByClickThroughRateDesc(List<Book> bookList) {
		return null;
	}

}