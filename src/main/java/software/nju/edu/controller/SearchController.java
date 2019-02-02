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
import software.nju.edu.serviceimpl.userServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private userServiceImpl userService;
	@Autowired
	private bookServiceImpl bookService;
	@Autowired
	private BookMapper BookMapper;
	
	@GetMapping("/searchAll")
	public String searchBooksInAll(String uId,String key, Model model) {
		List<Book> books = BookMapper.getAllBooks();
		
		// Search Engine 
		SEOLogic seo = new SEOLogic();
		
		List<Book> queryResultBookList = null;
		try {		
			queryResultBookList = seo.start(books, key);
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
