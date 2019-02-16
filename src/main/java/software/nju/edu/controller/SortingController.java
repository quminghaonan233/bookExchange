package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.SearchEngineOptimizationServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class SortingController {
	
	@Autowired
	private SearchEngineOptimizationServiceImpl searchEngineOptimizationService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private BookMapper bookMapper;
	
	@GetMapping("/searchAll/byCredit")
	public String sortingByCredit(String uId, String key, Model model) {
		
		List<Book> books = bookMapper.getAllBooks();
		
		List<Book> bookList = null;
		try {
			bookList = searchEngineOptimizationService.start(books, key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("bookList", bookList);
		model.addAttribute("key", key);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		
		return "searchAll";
	}
	
	
	@GetMapping("/searchAll/byTime")
	public String sortingByTimestamp() {
		
		return "searchAll";
	}

}
