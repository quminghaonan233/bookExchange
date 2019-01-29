package software.nju.edu.domain.entity;

public class Book {
	
	private String bid; // 书的id
	private String title; // 书的标题
	private String author; // 书的作者
	private float price; // 原价
	private int points; // 兑换积分 默认1000积分价值等同为1元，10元的书价值10000积分
	private float discount; // 折扣 = 兑换积分／（原价*1000）* 100%
	private String picname; // 书的图片名称
	private String desc; // 书的描述
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

	
	
	

}
