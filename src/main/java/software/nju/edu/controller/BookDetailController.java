package software.nju.edu.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.WebData;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.mapper.WebDataMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.service.impl.WebDataServiceImpl;

@Controller
public class BookDetailController {

	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private WebDataServiceImpl webDataService;

	@RequestMapping("/bookDetail")
	public String bookDetail(String bId, String uId, Model model) {
		System.out.println(uId);
		// get book detail.
		Book book = bookMapper.getBookDetail(Integer.valueOf(bId));
		// update Book Views and Clicks.
		webDataService.updateBookViews(Integer.parseInt(bId));
		webDataService.updateBookClicks(Integer.parseInt(bId));
		// get web data.
		WebData webData = webDataService.getWebDataByBookId(Integer.parseInt(bId));
		// 判断书籍是否为我发布的。
		boolean isBookMine = bookService.queryBookIsMine(Integer.parseInt(uId), Integer.parseInt(bId));
		// add attribute into model.
		model.addAttribute(webData);
		model.addAttribute(book);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		model.addAttribute("tradeMessage", new TradeMessage());
		model.addAttribute("isBookMine", isBookMine);
		//System.out.println(model.toString());
		return "bookDetail";
	}

	@RequestMapping("/bookModify")
	public String bookModify(String bookName, String bookType, String publisher, String author, String newDegree,
			String address, String onsale, String bookPrice, String uId, String bId, String isDel, String img,
			Model model) {
		// 调修改接口
		Date finalUpdateTime = new Timestamp(System.currentTimeMillis());
		Book book = new Book(Integer.parseInt(bId), bookName, Integer.parseInt(uId), bookType, publisher, author, newDegree, address,
				Integer.parseInt(onsale), Integer.parseInt(isDel), Integer.parseInt(bookPrice), img, finalUpdateTime);
		bookService.updateBookDetail(book);
		return "redirect:/bookDetail?bId=" + bId + "&uId=" + uId;
	}

	@RequestMapping("/bookDel")
	public String bookDel(String bId, String uId, Model model) {
		// 调删除接口
		bookService.deleteBook(Integer.parseInt(bId));
		return "redirect:/index?uId=" + uId;
	}

	public String bookImageUpdate(int bId, String img, String uId) {
		// updateBookImage interface
		bookService.updateBookImage(bId, img);
		return "redirect:/bookDetail?bId=" + bId + "&uId=" + uId;

	}

}
