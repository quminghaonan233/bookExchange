package software.nju.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import software.nju.edu.domain.entity.Book;

public interface BookMapper {
	
	/**
	 * Select
	 * @return
	 */
	@Select("SELECT * FROM book")
	@Results({
		@Result(property = "bId", column = "bId"),
		@Result(property = "bookName", column = "bookName")
	})
	List<Book> getAllBooks();
	
	@Select("SELECT * FROM book WHERE bId = #{bId}")
	Book getBookDetail(int bId);
	
	/**
	 * Select and Sort(Order By)
	 * @return
	 */
	@Select("SELECT * FROM book ORDER BY newDegree DESC")
	List<Book> getAllBooksOrderByNewDegreeDesc();
	
	@Select("SELECT * FROM book ORDER BY newDegree ASC")
	List<Book> getAllBooksOrderByNewDegreeAsc();
	
	@Select("SELECT * FROM book ORDER BY price DESC ")
	List<Book> getAllBooksOrderByPriceDesc();
	
	@Select("SELECT * FROM book ORDER BY price ASC")
	List<Book> getAllBooksOrderByPriceAsc();
	
	/**
	 * Insert
	 * @param book
	 */
	@Insert("INSERT INTO book(bookName, book_owner, bookType, "
			+ "publisher, author, newDegree, address, onsale, isDel, price, img) "
			+ "VALUES (#{bookName}, #{book_owner}, #{bookType}, "
			+ "#{publisher}, #{author}, #{newDegree}, #{address}, "
			+ "#{onsale}, #{isDel}, #{price}, #{img}")
	void addNewBook(Book book);
	
	/**
	 * Update
	 * @param book
	 */
	@Update("UPDATE book SET userName = #{userName} "
			+ "book_owner = #{book_owner}, "
			+ "bookType = #{bookType}, "
			+ "publisher = #{publisher}, "
			+ "author = #{author}, "
			+ "newDegree = #{newDegree}, "
			+ "address = #{address}, "
			+ "onsale = #{onsale}, "
			+ "isDel = #{isDel}, "
			+ "price = #{price}, "
			+ "img = #{img} "
			+ "WHERE bId = #{bId}")
	void updateBookDetail(Book book);
	
	
	/**
	 * 3 status for onsale. onsale = 0, 1, 2.
	 * @param bId
	 */
	@Update("UPDATE book SET onsale = 0 WHERE bId = #{bId}")
	void alterBookWaitSale(int bId);
	
	@Update("UPDATE book SET onsale = 1 WHERE bId = #{bId}")
	void alterBookOnSale(int bId);
	
	@Update("UPDATE book SET onsale = 2 WHERE bId = #{bId}")
	void alterBookSaleOut(int bId);
	
	/**
	 *  2 status for isDel. isDel = 0, 1.
	 * @param bId
	 */
	@Update("UPDATE book SET isDel = 0 WHERE bId = #{bId}")
	void alterBookIsNotDel(int bId);
		
	@Update("UPDATE book SET isDel = 1 WHERE bId = #{bId}")
	void alterBookIsDel(int bId);
		
	@Delete("Delete FROM book WHERE bId = #{bId}")
	void deleteBook(int bId);
	
	
	

}
