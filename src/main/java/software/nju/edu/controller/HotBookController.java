package software.nju.edu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.serviceimpl.bookServiceImpl;

@RestController
public class HotBookController {
	
	private bookServiceImpl bookService;
	
	@RequestMapping("/hotbook")
	public List<Book> showHotBooks() {
		List<Book> list = bookService.findHotBookList();
		
		return list;
		
	}

}
