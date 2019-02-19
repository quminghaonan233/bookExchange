package software.nju.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.User;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.mapper.UserMapper;
import software.nju.edu.mapper.WebDataMapper;
import software.nju.edu.service.BookService;
import software.nju.edu.util.PageInfoUtil;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WebDataMapper webDataMapper;
	
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
		int bId = bookMapper.getLastInsertId();
		System.out.println("add new book and return bId:" + bId);
		webDataMapper.addWebData(bId);
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

	@Override
	public int getCreditByBookOwner(int book_owner) {
		// TODO Auto-generated method stub
		User user = userMapper.getUserById(book_owner);
		return user.getCredit();
	}
	
	public PageInfo<Book> getBookListByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Book> allBooks = bookMapper.getAllBooks();
		
		// create PageInfo
		PageInfo<Book> pageInfo = new PageInfo<Book>(allBooks);
		// by page
		return pageInfo;
		
	}
	
	public PageInfo<Book> getHotBookListByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// get bookList
		List<Book> bookList = bookMapper.getAllBooksOrderByNewDegreeDesc();
		// create PageInfo for Hot Books on /index
		PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
		// return pageInfo
		return pageInfo;
		
	}
	
	public PageInfoUtil<Book> getBookListByPage(List<Book> bookList, int pageNum, int pageSize) {
		// PageHelper.startPage(pageNum, pageSize);		
		// create PageInfo
		
		
		PageInfoUtil<Book> pageInfo = new PageInfoUtil<Book>(bookList, pageNum, pageSize);
		
		
		System.out.println("pageInfo.toString():");
		System.out.println(pageInfo);
		// by page
		return pageInfo;
		
	}
	
	
 
}
