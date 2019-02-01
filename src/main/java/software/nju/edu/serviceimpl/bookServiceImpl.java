package software.nju.edu.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.bookService;

public class bookServiceImpl implements bookService {

	@Override
	public List<Book> findHotBookList() {
		// TODO Auto-generated method stub
		
		List<Book> list = new ArrayList<Book>();
		Book b1 = new Book(10000, "Java编程", "alice");
		Book b2 = new Book(10001, "Java入门", "bob");
		Book b3 = new Book(10002, "Java精通", "cici");
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		return list;
	}
	
	

}
