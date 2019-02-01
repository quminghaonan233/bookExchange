package software.nju.edu.domain.impl;

import java.util.ArrayList;
import java.util.List;

import software.nju.edu.domain.dao.BookDao;
import software.nju.edu.domain.entity.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> queryBookList() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		
		
		
		return list;
		
	}

	@Override
	public Book getBookById(int bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookById(int bId) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
