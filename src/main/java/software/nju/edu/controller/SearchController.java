package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.seo.SEOLogic;
import software.nju.edu.serviceimpl.bookServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private bookServiceImpl bookService;
	@Autowired
	private BookMapper BookMapper;
	
	@GetMapping("/searchAll/{key}")
	public String searchBooksInAll(@PathVariable String key, Model model) {
		List<Book> books = BookMapper.getAllBooks();
		System.out.println("aaa" + books);
		
		// Search Engine 
		SEOLogic seo = new SEOLogic();
		
		List<Book> queryResultBookList = null;
		try {		
			queryResultBookList = seo.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("queryResultBookList", queryResultBookList);
		return "/searchAll";
	}
	
	@GetMapping("/searchMine")
	public String searchBooksInMine(String key, Model model) {
		List<Book> list = bookService.findBookListWithKey(key);
		model.addAttribute("mineBookList",list);
		return "/searchMine";
	}
	
	@ResponseBody
	@RequestMapping("/searchAll/{key}")
	public String getSearchKey(@PathVariable String key) {
		
		//model.addAttribute("key",key);
		
		return key;
	}

}
