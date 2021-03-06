package software.nju.edu.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface BookService {

	// update Book Image
	public void updateBookImage(int bId, String img, Timestamp finalUpdateTime);
	
	public Book getBookById(int bId);
	// get bookName
	public String getBookName(int bId);

	// add a new book
	public void addNewBook(Book book);

	// update a book
	public void updateBook(Book book);

	// delete a book
	public void deleteBook(int bId);

	// for sale (onsale = 0) 待售 挂起
	public void forSaleBook(int bId);

	// on sale (onsale = 1) 出售中
	public void onSaleBook(int bId);

	// sell Out (onsale = 2) 售出 下架
	public void sellOutBook(int bId);

	public void updateBookDetail(Book book);
	
	public List<Book> findHotBookList();

	public List<Book> findBookListWithKey(String key);

	public void sortBookList(List<Book> bookList);

	public boolean queryBookIsMine(int uId, int bId);

	public List<Book> getMineBooks(int uId);
	
	public int getCreditByBookOwner(int book_owner);

}
