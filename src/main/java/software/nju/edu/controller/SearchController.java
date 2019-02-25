package software.nju.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.entity.SearchResult;
import software.nju.edu.domain.entity.WebData;
import software.nju.edu.mapper.BookMapper;
import software.nju.edu.service.impl.BookServiceImpl;
import software.nju.edu.service.impl.SearchEngineOptimizationServiceImpl;
import software.nju.edu.service.impl.SortingServiceImpl;
import software.nju.edu.service.impl.UserServiceImpl;
import software.nju.edu.service.impl.WebDataServiceImpl;
import software.nju.edu.util.PageInfoUtil;

@Controller
public class SearchController {

	@Autowired
	private SearchEngineOptimizationServiceImpl searchEngineOptimizationService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private SortingServiceImpl sortingService;
	@Autowired
	private WebDataServiceImpl webDataService;

	public void creditListLinkToBookList(List<Book> bookList, List<Integer> creditList) {
		System.out.println(bookList);
		for (Book b : bookList) {
			creditList.add(bookService.getCreditByBookOwner(b.getBook_owner()));
		}
		
	}
	
	public void webDataListLinkToBookList(List<Book> bookList, List<WebData> webDataList) {
		for (Book b: bookList) {
			webDataList.add(webDataService.getWebDataByBookId(b.getbId()));
		}
	}
	
	public List<SearchResult> mergeSearchResultList(List<Book> bookList, List<Integer> creditList, List<WebData> webDataList) {
		List<SearchResult> finalList = new ArrayList<SearchResult>();
		//int size = bookList.size();
		int localSize = 0;
		for (Book b : bookList) {
			int credit = creditList.get(localSize);
			WebData webData = webDataList.get(localSize);
			SearchResult sr = new SearchResult(b, credit, webData);
			finalList.add(sr);
			localSize ++;
		}
		return finalList;
		
	}
	
	@GetMapping("/searchAll")
	public String searchBooksInAll(String uId, String key,
			@RequestParam(value = "sort", defaultValue = "0") int sort,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {
		List<Book> books = bookMapper.getAllBooks();
		List<Book> queryResultBookList = null;
		List<Integer> creditList = new ArrayList<Integer>();
		List<WebData> webDataList = new ArrayList<WebData>();
		
		
		
		
		
		try {
			queryResultBookList = searchEngineOptimizationService.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int hitCounts = queryResultBookList.size();
		
		
		switch(sort) {
		case 0:
			break;	
		case 1:
			queryResultBookList = sortingService.sortedByCreditAsc(queryResultBookList);
			break;
		case 2:
			queryResultBookList = sortingService.sortedByCreditDesc(queryResultBookList);
			break;
		case 3:
			queryResultBookList = sortingService.sortedByPriceAsc(queryResultBookList);
			break;
		case 4:
			queryResultBookList = sortingService.sortedByPriceDesc(queryResultBookList);
			break;
		case 5:
			queryResultBookList = sortingService.sortedByTimeAsc(queryResultBookList);
			break;
		case 6:
			queryResultBookList = sortingService.sortedByTimeDesc(queryResultBookList);
			break;
		case 7:
			queryResultBookList = sortingService.sortedByHotIndexAsc(queryResultBookList);
			break;
		case 8:
			queryResultBookList = sortingService.sortedByHotIndexDesc(queryResultBookList);
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		}

		creditListLinkToBookList(queryResultBookList, creditList);
		webDataListLinkToBookList(queryResultBookList, webDataList);
		List<SearchResult> searchResultList = mergeSearchResultList(queryResultBookList, creditList, webDataList);
		PageInfoUtil<SearchResult> bookPageInfo = bookService.getSearchResultListByPage(searchResultList, pageNum, pageSize);

		// update views for each book.
		for (SearchResult sr : bookPageInfo.getList()) {
			int bId = sr.getBook().getbId();
			webDataService.updateBookViews(bId);
		}
		
		
		model.addAttribute("pageInfo", bookPageInfo);
		model.addAttribute("hitCounts", hitCounts);
		model.addAttribute("key", key);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/searchAll";
	}

	@GetMapping("/searchMine")
	public String searchBooksInMine(String uId, String key, Model model) {

		List<Book> books = bookService.getMineBooks(Integer.valueOf(uId));
		List<Book> queryResultBookList = null;
		try {
			queryResultBookList = searchEngineOptimizationService.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("mineBookList", queryResultBookList);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(uId)));
		return "/searchMine";
	}

	@ResponseBody
	@RequestMapping("/searchAll/{key}")
	public String getSearchKey(@PathVariable String key) {

		// model.addAttribute("key",key);

		return key;
	}

}
