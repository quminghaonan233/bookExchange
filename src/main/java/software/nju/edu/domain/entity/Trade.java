package software.nju.edu.domain.entity;

import java.io.Serializable;
import java.util.Date;

import software.nju.edu.bean.LogisticsInfo;

public class Trade implements Serializable {
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attributes
	 */
	private int tId;           // Primary key
	private int buyerId;       // Foreign key: uId
	private String buyerName; 
	private int sellerId;      // Foreign key: uId
	private String sellerName;
	private int bId;           // Foreign key: bId
	private String bookName;
	private Date start;
	private Date end;
	private String sendTo;
	private String description;
	private int status;
	private LogisticsInfo li;


	// constructor without argument.
	public Trade() {

	}

	public Trade(int buyerId, String buyerName, int sellerId, String sellerName, int bId, String bookName, Date start,
			String sendTo, String description, int status) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.bId = bId;
		this.bookName = bookName;
		this.start = start;
		this.sendTo = sendTo;
		this.description = description;
		this.status = status;
	}

	// constructor with several arguments.
	public Trade(int tId, int buyerId, int sellerId, int bId) {
		this.tId = tId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.bId = bId;
	}

	// getters and setters
	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LogisticsInfo getLi() {
		return li;
	}

	public void setLi(LogisticsInfo li) {
		this.li = li;
	}	
	
}
