package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import software.nju.edu.domain.entity.Book;

public interface BookMapper {
	
	
	@Select("SELECT * FROM book")
	@Results({
		@Result(property = "bookId", column = "bId"),
		@Result(property = "bookName", column = "bookName")
	})
	List<Book> getAllBooks();
	

}
