package software.nju.edu.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Run.class)
//@EnableAutoConfigutation
public class SortingServiceImplTest {
	
	@Autowired
	BookMapper bookMapper;
	
	public void Test() {
		// List<Book> bookList = bookMapper.getAllBooks();
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book(2018, 3000));
		bookList.add(new Book(2019, 4000));
		bookList.add(new Book(2020, 5000));
		bookList.add(new Book(20201,2800));
		
		for(Book b: bookList) {
			System.out.println(b.getbId() + ", " + b.getPrice());
		}
		
		new SortingServiceImpl().sortedByPrice(bookList);
		
	}
	
	public static void main(String[] args) {
		
		new SortingServiceImplTest().Test();
		
	}

}
