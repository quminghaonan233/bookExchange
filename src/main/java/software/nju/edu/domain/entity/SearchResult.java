package software.nju.edu.domain.entity;

public class SearchResult {
	private Book book;
	private int credit;
	private WebData webData;
	
	public SearchResult() {
		
	}
	
	public SearchResult(Book book, int credit, WebData webData) {
		this.book = book;
		this.credit = credit;
		this.webData = webData;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public WebData getWebData() {
		return webData;
	}
	
	public void setWebData(WebData webData) {
		this.webData = webData;
	}
	

}
