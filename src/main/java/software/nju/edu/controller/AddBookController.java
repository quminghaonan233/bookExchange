package software.nju.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.serviceimpl.bookServiceImpl;
import software.nju.edu.util.FileUtil;

@Controller
public class AddBookController {
	
	@Autowired
	bookServiceImpl bookService;
	
	@GetMapping("/addBook")
	public String addBook() {
		return "addBook";
	}
	
	@PostMapping("/addBook")
	public String upload(HttpServletRequest request) {
		System.out.println("return...");
		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
		String fileName = file.getOriginalFilename();
		String filePath = "/Users/huanghj/img/";
		
		int bId = Integer.valueOf(params.getParameter("bId"));
		String bookName = params.getParameter("bookName");
		String book_owner = params.getParameter("book_owner");
		String publisher = params.getParameter("publisher");
		String author = params.getParameter("author");
		String newDegree = params.getParameter("author");
		String address = params.getParameter("author");
		int onsale = Integer.valueOf(params.getParameter("onsale"));
		int isDel = Integer.valueOf(params.getParameter("isDel"));
		int price = Integer.valueOf(params.getParameter("price"));
		String img = filePath + fileName;
		
		Book book = new Book();
		book.setbId(bId);
		book.setBookName(bookName);
		book.setBook_owner(book_owner);
		book.setPublisher(publisher);
		book.setAuthor(author);
		book.setNewDegree(newDegree);
		book.setAddress(address);
		book.setOnsale(onsale);
		book.setIsDel(isDel);
		book.setPrice(price);
		book.setImg(img);
		
		bookService.addNewBook(book);
		
		try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			
		}
		
		return "myBook";
	}

}
