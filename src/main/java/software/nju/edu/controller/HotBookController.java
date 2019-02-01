package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.serviceimpl.bookServiceImpl;

@Controller
public class HotBookController {
	
	@Autowired
	private bookServiceImpl bookService;
	
	@GetMapping("/")
	public String showHotBooks(Model model) {
		List<Book> list = bookService.findHotBookList();
		model.addAttribute("hotBookList", list);
		return "index";
		
	}

}
