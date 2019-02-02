package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;


@Controller
public class BookDetailController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BookMapper bookMapper;
	
	@RequestMapping("/bookDetail")
	public String bookDetail(String bId,String uId, Model model){
		System.out.println(uId);
		Book book = bookMapper.getBookDetail(Integer.valueOf(bId));
		model.addAttribute(book);
		model.addAttribute("user",userService.getUserById(Integer.parseInt(uId)));
		model.addAttribute("tradeMessage",new TradeMessage());
		boolean isBookMine = bookService.queryBookIsMine(Integer.parseInt(uId),Integer.parseInt(bId));
		model.addAttribute("isBookMine",isBookMine);
		System.out.println(model.toString());
	    return "bookDetail";
	}
	
	@RequestMapping("/bookModify")
	public String bookModify(String bookName,String bookType,String bookPublisher,String bookAuthor,String bookNewDegree,String address,String onsale,String bookOnsale,String uId,String bId,String isDel,Model model){
		//调修改接口
	    return "redirect:/bookDetail?bId="+bId+"&uId="+uId;
	}
	
	@RequestMapping("/bookDel")
	public String bookDel(String bId,String uId,Model model) {
		//调删除接口
		return "redirect:/index?uId="+uId;
	}
	
}
