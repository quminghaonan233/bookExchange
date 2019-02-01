package software.nju.edu.domain.entity;

import java.io.Serializable;

public class Book implements Serializable {	
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	private int bId; // 书的id
	private String bookName; // book name
	private String book_owner; // FK uId
	private String bookType; // book class
	private String publisher; 
	private String author;
	private String newDegree;
	private String address;
	private int onsale;
	private int isDel;
	private int price;
	private String img;
	
	// constructor without argument.
	public Book() {
		
	}
	
	// constructor with several arguments.
	public Book(int bId, String bookName, String book_owner) {
		this.bId = bId;
		this.bookName = bookName;
		this.book_owner = book_owner;
		 
	}
	
	//getters and setters
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBook_owner() {
		return book_owner;
	}
	public void setBook_owner(String book_owner) {
		this.book_owner = book_owner;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNewDegree() {
		return newDegree;
	}
	public void setNewDegree(String newDegree) {
		this.newDegree = newDegree;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOnsale() {
		return onsale;
	}
	public void setOnsale(int onsale) {
		this.onsale = onsale;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Book{" +
			   "bId=" + bId +
			   "bookName=" + bookName +
			   "book_owner=" + book_owner +
			   "bookType=" + bookType +
			   "publisher=" + publisher +
			   "author=" + author +
			   "newDegree=" + newDegree +
			   "address=" + address +
			   "onsale=" + onsale +
			   "isDel=" + isDel +
			   "price=" + price +
			   "img=" + img +
			   "}";
			   
	}
	

}
