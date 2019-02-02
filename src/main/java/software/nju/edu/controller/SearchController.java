package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.SearchEngineOptimizationServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private SearchEngineOptimizationServiceImpl searchEngineOptimizationService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private BookMapper bookMapper;
	
	@GetMapping("/searchAll")
	public String searchBooksInAll(String uId,String key, Model model) {
		List<Book> books = bookMapper.getAllBooks();
		
		// Search Engine 
		//SearchEngineOptimizationServiceImpl seo = new SearchEngineOptimizationServiceImpl();
		
		List<Book> queryResultBookList = null;
		try {		
			queryResultBookList = searchEngineOptimizationService.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(queryResultBookList);
		model.addAttribute("queryResultBookList", queryResultBookList);
		model.addAttribute("key",key);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		return "/searchAll";
	}
	
	@GetMapping("/searchMine")
	public String searchBooksInMine(String uId, String key, Model model) {
		
		List<Book> books = bookService.getMineBooks(Integer.valueOf(uId));
		List<Book> queryResultBookList = null;
		try {		
			queryResultBookList = searchEngineOptimizationService.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("mineBookList",queryResultBookList);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		return "/searchMine";
	}
	
	@ResponseBody
	@RequestMapping("/searchAll/{key}")
	public String getSearchKey(@PathVariable String key) {
		
		//model.addAttribute("key",key);
		
		return key;
	}

}
