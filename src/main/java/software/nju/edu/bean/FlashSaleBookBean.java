package software.nju.edu.bean;

import java.sql.Timestamp;
import java.util.Date;

public class FlashSaleBookBean {
	
	private int bId; // Primary key
	private String bookName;
	private int book_owner; // Foreign Key: uId
	private String bookType;
	private String publisher;
	private String author;
	private String newDegree;
	private String address;
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
	public Timestamp getFinalUpdateTime() {
		return finalUpdateTime;
	}
	public void setFinalUpdateTime(Timestamp finalUpdateTime) {
		this.finalUpdateTime = finalUpdateTime;
	}
	public int getFlashSalePrice() {
		return flashSalePrice;
	}
	public void setFlashSalePrice(int flashSalePrice) {
		this.flashSalePrice = flashSalePrice;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	private int onsale;
	private int isDel;
	private int price;
	private String img;
	private Timestamp finalUpdateTime;
	
	private int flashSalePrice;
	private Date startTime;
	private Date endTime;
	

}
