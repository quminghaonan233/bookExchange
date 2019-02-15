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
	
	@Select("SELECT bookName FROM book WHERE bId = #{bId}")
	String getBookNameByBookId(int bId);
	
	@Select("SELECT * FROM book")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> getAllBooks();
	
	@Select("SELECT * FROM book WHERE bId = #{bId}")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	Book getBookDetail(int bId);
	
	@Select("SELECT COUNT(*) FROM book WHERE bId = #{bId} AND book_owner = #{uId}")
	int queryMineBooksByBookIdAndUserId(int bId, int uId);
	
	@Select("SELECT * FROM book WHERE book_owner = #{uId}")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> queryMineBooksByUserId(int uId);
	
	/**
	 * Select and Sort(Order By)
	 * @return
	 */
	@Select("SELECT * FROM book ORDER BY newDegree DESC")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> getAllBooksOrderByNewDegreeDesc();
	
	@Select("SELECT * FROM book ORDER BY newDegree ASC")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> getAllBooksOrderByNewDegreeAsc();
	
	@Select("SELECT * FROM book ORDER BY price DESC ")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> getAllBooksOrderByPriceDesc();
	
	@Select("SELECT * FROM book ORDER BY price ASC")
	@Results({
		@Result(property = "finalUpdateTime", column = "final_update_time")
	})
	List<Book> getAllBooksOrderByPriceAsc();
	
	/**
	 * Insert
	 * @param book
	 */
	@Insert("INSERT INTO book(bookName, book_owner, bookType, "
			+ "publisher, author, newDegree, address, onsale, isDel, price, img, final_update_time) "
			+ "VALUES (#{bookName}, #{book_owner}, #{bookType}, "
			+ "#{publisher}, #{author}, #{newDegree}, #{address}, "
			+ "#{onsale}, #{isDel}, #{price}, #{img}, #{finalUpdateTime}"
			+ ")")
	void addNewBook(Book book);
	
	/**
	 * Update
	 * @param book
	 */
	@Update("UPDATE book SET bookName = #{bookName}, "
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
	

	@Update("UPDATE book SET img = #{img} WHERE bId = #{bId}")
	void updateBookImage(int bId, String img);
	
	
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
