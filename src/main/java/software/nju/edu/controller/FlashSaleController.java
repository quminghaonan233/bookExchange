package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.service.impl.WebDataServiceImpl;

@Controller
public class FlashSaleController {
	
	@Autowired
	UserServiceImpl userService;
	@Autowired
	BookServiceImpl bookService;
	@Autowired
	WebDataServiceImpl webDataService;
	
	@GetMapping("/flashSale")
	public String flashSale(String uId, 
			@RequestParam(value="pageNum", defaultValue="1") int pageNum, 
			@RequestParam(value="pageSize", defaultValue="5") int pageSize,
			Model model) {
		// get book page info.
		PageInfo<Book> bookPageInfo = bookService.getFlashSaleBookListByPage(pageNum, pageSize);
		
		// update views for each book.
		for (Book book : bookPageInfo.getList()) {
			int bId = book.getbId();
			webDataService.updateBookViews(bId);
		}
		
		int discount = 70;
		model.addAttribute("discount", discount);
		model.addAttribute("pageInfo", bookPageInfo);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/flashSale";
	}
	

}
