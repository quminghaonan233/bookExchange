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

	public List<Book> sortedByPara(List<Book> books, int sort) {
		switch (sort) {
		case 0:
			break;
		case 1:
			books = this.sortedByCreditAsc(books);
			break;
		case 2:
			books = this.sortedByCreditDesc(books);
			break;
		case 3:
			books = this.sortedByPriceAsc(books);
			break;
		case 4:
			books = this.sortedByPriceDesc(books);
			break;
		case 5:
			books = this.sortedByTimeAsc(books);
			break;
		case 6:
			books = this.sortedByTimeDesc(books);
			break;
		case 7:
			books = this.sortedByHotIndexAsc(books);
			break;
		case 8:
			books = this.sortedByHotIndexDesc(books);
			break;
		case 9:
			books = this.sortedByClicksAsc(books);
			break;
		case 10:
			books = this.sortedByClicksDesc(books);
			break;
		case 11:
			books = this.sortedByViewsAsc(books);
			break;
		case 12:
			books = this.sortedByViewsDesc(books);
			break;
		case 13:
			books = this.sortedByClickThroughRateAsc(books);
			break;
		case 14:
			books = this.sortedByClickThroughRateDesc(books);
			break;
		}
		return books;
	}

	/**
	 * 按价格升序
	 * 
	 * @param bookList
	 * @return
	 */
	@Override
	public List<Book> sortedByPriceAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer) b1.getPrice()).compareTo(b2.getPrice());
			}
		});
//		for (Book b: bookList) {
//			System.out.println(b.getbId() + ", " + b.getPrice());
//		}
		return bookList;
	}

	/**
	 * 按价格降序
	 * 
	 * @param bookList
	 * @return
	 */
	@Override
	public List<Book> sortedByPriceDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return ((Integer) b2.getPrice()).compareTo(b1.getPrice());
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
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> webData -> hot-index
				float h1 = bookService.getHotIndexByBookId(b1.getbId());
				// find b2 -> webData -> hot-index
				float h2 = bookService.getHotIndexByBookId(b2.getbId());
				return Float.compare(h1, h2);

			}
		});
		return bookList;
	}

	/**
	 * 按热点值降序
	 */
	@Override
	public List<Book> sortedByHotIndexDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> webData -> hot-index
				float h1 = bookService.getHotIndexByBookId(b1.getbId());
				// find b2 -> webData -> hot-index
				float h2 = bookService.getHotIndexByBookId(b2.getbId());
				return Float.compare(h2, h1);

			}
		});
		return bookList;
	}

	/**
	 * 按点击数升序
	 */
	@Override
	public List<Book> sortedByClicksAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> webData -> clicks
				int c1 = bookService.getClicksByBookId(b1.getbId());
				// find b2 -> webData -> clicks
				int c2 = bookService.getClicksByBookId(b2.getbId());
				return Integer.compare(c1, c2);

			}
		});
		return bookList;
	}

	/**
	 * 按点击数降序
	 */
	@Override
	public List<Book> sortedByClicksDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find b1 -> webData -> clicks
				int c1 = bookService.getClicksByBookId(b1.getbId());
				// find b2 -> webData -> clicks
				int c2 = bookService.getClicksByBookId(b2.getbId());
				return Integer.compare(c2, c1);

			}
		});
		return bookList;
	}

	/**
	 * 按浏览数升序
	 */
	@Override
	public List<Book> sortedByViewsAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find v1 -> webData -> views
				int v1 = bookService.getViewsByBookId(b1.getbId());
				// find v2 -> webData -> views
				int v2 = bookService.getViewsByBookId(b2.getbId());
				return Integer.compare(v1, v2);

			}
		});
		return bookList;
	}

	/**
	 * 按浏览数降序
	 */
	@Override
	public List<Book> sortedByViewsDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find v1 -> webData -> views
				int v1 = bookService.getViewsByBookId(b1.getbId());
				// find v2 -> webData -> views
				int v2 = bookService.getViewsByBookId(b2.getbId());
				return Integer.compare(v2, v1);

			}
		});
		return bookList;
	}

	/**
	 * 按点击率升序
	 */
	@Override
	public List<Book> sortedByClickThroughRateAsc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find ctr1 -> webData -> hot-index
				float ctr1 = bookService.getClickThroughRateByBookId(b1.getbId());
				// find ctr2 -> webData -> hot-index
				float ctr2 = bookService.getClickThroughRateByBookId(b2.getbId());
				return Float.compare(ctr1, ctr2);

			}
		});
		return bookList;
	}

	/**
	 * 按点击率降序
	 */
	@Override
	public List<Book> sortedByClickThroughRateDesc(List<Book> bookList) {
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				// find ctr1 -> webData -> hot-index
				float ctr1 = bookService.getClickThroughRateByBookId(b1.getbId());
				// find ctr2 -> webData -> hot-index
				float ctr2 = bookService.getClickThroughRateByBookId(b2.getbId());
				return Float.compare(ctr2, ctr1);

			}
		});
		return bookList;
	}

}