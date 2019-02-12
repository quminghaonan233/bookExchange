package software.nju.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public void updateBookImage(int bId, String img) {
		bookMapper.updateBookImage(bId, img);
	}
	
	@Override
	public Book getBookById(int bId) {
		Book b = bookMapper.getBookDetail(bId);
		return b;
	}

	@Override
	public String getBookName(int bId) {
		String bookName = bookMapper.getBookNameByBookId(bId);
		return bookName;
	}

	@Override
	public void addNewBook(Book book) {
		bookMapper.addNewBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookMapper.updateBookDetail(book);
	}

	@Override
	public void deleteBook(int bId) {
		bookMapper.deleteBook(bId);
	}

	@Override
	public void forSaleBook(int bId) {
		// 待售 挂起 onsale = 0
		bookMapper.alterBookWaitSale(bId);
	}

	@Override
	public void onSaleBook(int bId) {
		// 出售 onsale = 1
		bookMapper.alterBookOnSale(bId);
	}

	@Override
	public void sellOutBook(int bId) {
		// 售完 onsale = 2
		bookMapper.alterBookSaleOut(bId);
	}

	@Override
	public void updateBookDetail(Book book) {
		bookMapper.updateBookDetail(book);
		
	}
	
	@Override
	public List<Book> findHotBookList() {
		// assume this is the hot book list.
		List<Book> list = bookMapper.getAllBooksOrderByNewDegreeDesc();
		return list;
	}

	@Override
	public List<Book> findBookListWithKey(String key) {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		Book b1 = new Book(10000, "Java基础编程", "alice");
		Book b2 = new Book(10001, "Java入门", "bob");
		Book b3 = new Book(10002, "Java精通", "cici");
		Book b4 = new Book(10001, "Java高手", "bob");
		Book b5 = new Book(10002, "Java宗师", "cici");
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);

		return list;
	}

	@Override
	public void sortBookList(List<Book> bookList) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean queryBookIsMine(int uId, int bId) {
		// res = 0, true; res = 1, flase;
		boolean flag = true;
		int res = bookMapper.queryMineBooksByBookIdAndUserId(bId, uId);
		if (res == 0)
			flag = false;
		else if (res == 1)
			flag = true;
		return flag;
	}

	@Override
	public List<Book> getMineBooks(int uId) {
		List<Book> list = bookMapper.queryMineBooksByUserId(uId);
		return list;
	}

}
