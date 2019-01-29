package software.nju.edu.domain.dao;

import java.util.List;

import software.nju.edu.domain.entity.Book;

public interface BookDao {
	
	List<Book> queryBookList();

}
