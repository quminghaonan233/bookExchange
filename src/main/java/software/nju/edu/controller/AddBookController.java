package software.nju.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.util.FileUtil;
import software.nju.edu.util.ImageUtil;

@Controller
public class AddBookController {

	@Autowired
	BookServiceImpl bookService;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/addBook")
	public String addBook(String uId, Model model) {
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "addBook";
	}

	@PostMapping("/addBookResult")
	public String upload(HttpServletRequest request, Model model) {

		String addBookResultMessage = "add New Book Successfully";

		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		MultipartFile file = params.getFile("file");
		String uId = params.getParameter("uId");

		String fileName = file.getOriginalFilename();
		String filePath = new ImageUtil().getImagePath();

		int onsale = 0;
		int isDel = 0;
		int price = 0;
		String bookName = null;
		String book_owner = null;
		String publisher = null;
		String author = null;
		String newDegree = null;
		String address = null;
		String img = null;

		try {
			bookName = params.getParameter("bookName");
			book_owner = params.getParameter("book_owner");
			publisher = params.getParameter("publisher");
			author = params.getParameter("author");
			newDegree = params.getParameter("author");
			address = params.getParameter("author");
			onsale = Integer.valueOf(params.getParameter("onsale"));
			isDel = Integer.valueOf(params.getParameter("isDel"));
			price = Integer.valueOf(params.getParameter("price"));
			img = filePath + fileName;

			try {
				Book book = new Book();
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

				try {
					// upload file: book image.
					FileUtil.uploadFile(file.getBytes(), filePath, fileName);
					// only then did bookService add New Book.
					bookService.addNewBook(book);

				} catch (Exception e) {
					addBookResultMessage = "add New Book Unsuccessfully : When upload image.";

				}

			} catch (Exception e) {
				addBookResultMessage = "add New Book Unsuccessfully : When write to database.";
			}

		} catch (Exception e) {
			addBookResultMessage = "add New Book Unsuccessfully : When get params.";

		}

		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		model.addAttribute("addBookResultMessage", addBookResultMessage);
		return "addBookResult";
	}

}
