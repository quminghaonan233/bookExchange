package software.nju.edu.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import software.nju.edu.domain.entity.Book;

public class BookMapperTest {
	
	@Autowired
	private BookMapper BookMapper;
	
	public void testGetAll() throws Exception {
		List<Book> books = BookMapper.getAllBooks();
		System.out.println(books);
	}
	
	

}
