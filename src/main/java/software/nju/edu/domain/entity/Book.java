package software.nju.edu.domain.entity;

public class Book {	
	private String bId; // 书的id
	private String bookName; // book name
	private String owner; // FK uId
	private String bookClass; // book class
	private String publisher; 
	private String author;
	private String newPercent;
	private String address;
	private int onsale;
	private int isDel;
	private int price;
	private String img;
	
	/**
	 * getters and setters
	 * 
	**/
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getBookClass() {
		return bookClass;
	}
	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
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
	public String getNewPercent() {
		return newPercent;
	}
	public void setNewPercent(String newPercent) {
		this.newPercent = newPercent;
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
