package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.serviceimpl.bookServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private bookServiceImpl bookService;
	@Autowired
	private BookMapper BookMapper;
	
	@GetMapping("/searchAll")
	public String searchBooksInAll(String key, Model model) {
		List<Book> list = bookService.findBookListWithKey(key);
		model.addAttribute("allBookList",list);
		List<Book> books = BookMapper.getAllBooks();
		System.out.println("aaa" + books);
		return "/searchAll";
	}
	
	@GetMapping("/searchMine")
	public String searchBooksInMine(String key, Model model) {
		List<Book> list = bookService.findBookListWithKey(key);
		model.addAttribute("mineBookList",list);
		return "/searchMine";
	}

}
