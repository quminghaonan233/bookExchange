package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.impl.BookServiceImpl;

@Controller
public class PageHelperTestController {

	@Autowired
	private BookServiceImpl bookService;

	@GetMapping("/pageHelperTest")
	public String bookInfoPageTest(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {

		List<Book> books = bookService.getBookListByPage(pageNum, pageSize);

		System.out.println("current page size:" + books.size());
		System.out.println(books);

		return "pageHelperTest";

	}

}
