package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface bookService {
	
	public List<Book> findHotBookList();
	
	public List<Book> findBookListWithKey(String key);
	
	public void sortBookList(List<Book> bookList);

}
