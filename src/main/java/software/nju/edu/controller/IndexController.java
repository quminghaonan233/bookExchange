package software.nju.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.User;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.service.impl.WebDataServiceImpl;
import software.nju.edu.util.TokenUtil;

@Controller
public class IndexController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	
	private WebDataServiceImpl webDataService;

	
	@RequestMapping("/index")
	public String hello(String uId, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model){		
		//身份校验
		TokenUtil util = TokenUtil.getInstance();
//		String uId = util.getuIdbyToken(token);
//		if(Integer.parseInt(uId) < 0) {
//			return "login";
//		}
		// get book page info.

		PageInfo<Book> bookPageInfo = bookService.getHotBookListByPage(pageNum, pageSize);

		// update views for each book.
		for (Book book : bookPageInfo.getList()) {
			int bId = book.getbId();
			webDataService.updateBookViews(bId);
		}
		
		model.addAttribute("pageInfo", bookPageInfo);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		System.out.println(model.toString());
	    return "index";
	}
	
	@RequestMapping("/myBook")
	public String myBook(String uId,Model model){
		List<Book> list = bookService.getMineBooks(Integer.valueOf(uId));
		User u = userService.getUserById(Integer.parseInt(uId));
		model.addAttribute("myBookList",list);
		model.addAttribute("user",u);
	    return "myBook";
	}

}
