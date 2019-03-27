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
		if(bookList != null) {
			for (Book b : bookList) {
				creditList.add(bookService.getCreditByBookOwner(b.getBook_owner()));
			}
		}

	}

	public void webDataListLinkToBookList(List<Book> bookList, List<WebData> webDataList) {
		if(bookList != null) {
			for (Book b : bookList) {
				webDataList.add(webDataService.getWebDataByBookId(b.getbId()));
			}
		}
	}

	public List<SearchResult> mergeSearchResultList(List<Book> bookList, List<Integer> creditList,
			List<WebData> webDataList) {
		List<SearchResult> finalList = new ArrayList<SearchResult>();
		// int size = bookList.size();
		int localSize = 0;
		if(bookList != null) {
			for (Book b : bookList) {
				int credit = creditList.get(localSize);
				WebData webData = webDataList.get(localSize);
				SearchResult sr = new SearchResult(b, credit, webData);
				finalList.add(sr);
				localSize++;
			}
		}
		return finalList;

	}

	/**
	 * 
	 * @param uId
	 * @param key
	 * @param sort
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@GetMapping("/searchAll")
	public String searchBooksInAll(String uId, String key, @RequestParam(value = "sort", defaultValue = "0") int sort,
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
		
		int hitCounts = 0;
		if(queryResultBookList != null) {
			hitCounts = queryResultBookList.size();

		}

		queryResultBookList = sortingService.sortedByPara(queryResultBookList, sort);

		creditListLinkToBookList(queryResultBookList, creditList);
		webDataListLinkToBookList(queryResultBookList, webDataList);
		List<SearchResult> searchResultList = mergeSearchResultList(queryResultBookList, creditList, webDataList);
		PageInfoUtil<SearchResult> bookPageInfo = bookService.getSearchResultListByPage(searchResultList, pageNum,
				pageSize);

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

	/**
	 * 
	 * @param uId
	 * @param key
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@GetMapping("/searchMine")
	public String searchBooksInMine(String uId, String key,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {
		// 调用bookService，获取我发布的book
		List<Book> books = bookService.getMineBooks(Integer.valueOf(uId));
		// 3个待处理的List
		List<Book> queryResultBookList = null;
		List<Integer> creditList = new ArrayList<Integer>();
		List<WebData> webDataList = new ArrayList<WebData>();
		try {
			// 调用 SEOService，根据key获取检索到的book
			queryResultBookList = searchEngineOptimizationService.start(books, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 匹配的book数量
		int hitCounts = queryResultBookList.size();
		// 根据检索结果bookList，绑定creditList
		creditListLinkToBookList(queryResultBookList, creditList);
		// 根据检索结果bookList，绑定webDataList
		webDataListLinkToBookList(queryResultBookList, webDataList);
		// 将3个List合并为1个List
		List<SearchResult> searchResultList = mergeSearchResultList(queryResultBookList, creditList, webDataList);
		PageInfoUtil<SearchResult> bookPageInfo = bookService.getSearchResultListByPage(searchResultList, pageNum,
				pageSize);
		
		// add attribute into model.
		model.addAttribute("pageInfo", bookPageInfo);
		model.addAttribute("hitCounts", hitCounts);
		model.addAttribute("key", key);
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
