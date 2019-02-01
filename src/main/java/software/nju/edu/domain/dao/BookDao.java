package software.nju.edu.domain.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import software.nju.edu.domain.entity.Book;

@Mapper
public interface BookDao {
	
	Book getBookById(@Param("bId") int bId);
	int updateBook(@Param("book") Book book);
	int insertBook(@Param("book") Book book);
	int deleteBookById(@Param("bId") int bId);
	List<Book> queryBookList();

}
