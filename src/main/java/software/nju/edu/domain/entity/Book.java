package software.nju.edu.domain.entity;

import java.io.Serializable;

public class Book implements Serializable {	
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attributes
	 */
	private int bId;           // Primary key
	private String bookName; 
	private int book_owner; // Foreign Key: uId
	private String bookType;
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
	
	public Book(int bId, int price) {
		this.bId = bId;
		this.price = price;
	}
	
	public Book(int bId, String bookName, int book_owner, String bookType, String publisher, String author,
			String newDegree, String address, int onsale, int isDel, int price, String img) {
		super();
		this.bId = bId;
		this.bookName = bookName;
		this.book_owner = book_owner;
		this.bookType = bookType;
		this.publisher = publisher;
		this.author = author;
		this.newDegree = newDegree;
		this.address = address;
		this.onsale = onsale;
		this.isDel = isDel;
		this.price = price;
		this.img = img;
	}

	// constructor with several arguments.
	public Book(int bId, String bookName, int book_owner) {
		this.bId = bId;
		this.bookName = bookName;
		this.book_owner = book_owner;
		 
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

	// getters and setters
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

	public int getBook_owner() {
		return book_owner;
	}

	public void setBook_owner(int book_owner) {
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

}
