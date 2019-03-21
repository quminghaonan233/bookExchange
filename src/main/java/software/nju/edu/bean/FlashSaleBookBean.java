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
	private int onsale;
	private int isDel;
	private int price;
	private String img;
	private Timestamp finalUpdateTime;
	
	private int flashSalePrice;
	private Date startTime;
	private Date endTime;
	

}
