package software.nju.edu.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.bookService;

@Service
public class bookServiceImpl implements bookService {

	@Override
	public List<Book> findHotBookList() {
		// TODO Auto-generated method stub
		
		List<Book> list = new ArrayList<Book>();
		Book b1 = new Book(10000, "Java编程", "alice");
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
	
	

}