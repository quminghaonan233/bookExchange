package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.impl.BookServiceImpl;

@Controller
public class PageHelperTestController {

	@Autowired
	private BookServiceImpl bookService;

	@GetMapping("/pageHelperTest")
	public String bookInfoPageTest(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {

		PageInfo<Book> bookPageInfo = bookService.getBookListByPage(pageNum, pageSize);
		model.addAttribute("pageInfo", bookPageInfo);
		
		System.out.println("current page size:" + bookPageInfo.getList().size());
		System.out.println(bookPageInfo.getList());
		return "pageHelperTest";

	}

}
