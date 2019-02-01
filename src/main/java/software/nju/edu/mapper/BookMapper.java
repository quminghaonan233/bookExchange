package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import software.nju.edu.domain.entity.Book;

public interface BookMapper {
	
	
	@Select("SELECT * FROM book")
	@Results({
		@Result(property = "bId", column = "bId"),
		@Result(property = "bookName", column = "bookName")
	})
	List<Book> getAllBooks();
	
	@Select("SELECT * FROM book ORDER BY newDegree DESC")
	List<Book> getAllBooksOrderByNewDegreeDesc();
	
	@Select("SELECT * FROM book ORDER BY newDegree ASC")
	List<Book> getAllBooksOrderByNewDegreeAsc();
	
	@Select("SELECT * FROM book ORDER BY price DESC ")
	List<Book> getAllBooksOrderByPriceDesc();
	
	@Select("SELECT * FROM book ORDER BY price ASC")
	List<Book> getAllBooksOrderByPriceAsc();
	
	

}
