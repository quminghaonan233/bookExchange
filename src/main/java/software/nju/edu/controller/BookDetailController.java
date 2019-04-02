package software.nju.edu.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import software.nju.edu.bean.TradeMessage;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.WebData;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.service.impl.WebDataServiceImpl;
import software.nju.edu.util.FileUtil;
import software.nju.edu.util.ImageUtil;
import software.nju.edu.util.UUIDUtil;

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
		// System.out.println(model.toString());
		return "bookDetail";
	}

	@RequestMapping("/modifyImg")
	public String modifyImg(HttpServletRequest request, Model model) {
		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		MultipartFile file = params.getFile("file");
		String uId = params.getParameter("uId");
		String bId = params.getParameter("bId");

		String fileName = file.getOriginalFilename();
		String uuidPath = new UUIDUtil().getUUID() + "/";
		String filePath = new ImageUtil().getImagePath() + uuidPath;
		//
		String img = filePath + fileName;
		try {
			// upload file: book image.
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
			Timestamp finalUpdateTime = new Timestamp(System.currentTimeMillis());
			// 调修改接口
			bookService.updateBookImage(Integer.parseInt(bId), img, finalUpdateTime);

		} catch (Exception e) {
			// addBookResultMessage = "add New Book Unsuccessfully : When upload image.";
			e.printStackTrace();

		}
		return "redirect:/bookDetail?bId=" + bId + "&uId=" + uId;
	}

	@RequestMapping("/bookModify")
	public String bookModify(String bookName, String bookType, String publisher, String author, String newDegree,
			String address, String onsale, String bookPrice, String uId, String bId, String isDel, String img, Model model) {
		// 调修改接口
		Timestamp finalUpdateTime = new Timestamp(System.currentTimeMillis());
		Book book = new Book(Integer.parseInt(bId), bookName, Integer.parseInt(uId), bookType, publisher, author,
				newDegree, address, Integer.parseInt(onsale), Integer.parseInt(isDel), Integer.parseInt(bookPrice), img,
				finalUpdateTime);
		bookService.updateBookDetail(book);

		return "redirect:/bookDetail?bId=" + bId + "&uId=" + uId;
	}

	@RequestMapping("/bookDel")
	public String bookDel(String bId, String uId, Model model) {
		// 调删除接口
		webDataService.deletebId(Integer.parseInt(bId));
		bookService.deleteBook(Integer.parseInt(bId));
		return "redirect:/index?uId=" + uId;
	}

}
