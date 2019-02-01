package software.nju.edu.service;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface bookService {
	
	public List<Book> findHotBookList();

}
