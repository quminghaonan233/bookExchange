package software.nju.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.serviceimpl.bookServiceImpl;
import software.nju.edu.serviceimpl.userServiceImpl;


@Controller
public class bookDetailController {
	
	@Autowired
	private bookServiceImpl bookService;
	
	@Autowired
	private userServiceImpl userService;
	@Autowired
	private BookMapper BookMapper;
	
	@RequestMapping("/bookDetail")
	public String bookDetail(String bId,String uId, Model model){
		System.out.println(uId);
		Book book = BookMapper.getBookDetail(Integer.valueOf(bId));
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
