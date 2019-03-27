package software.nju.edu.domain.entity;

import java.util.Date;
import java.util.List;

public class LogisticsInfo {
	private int lId;
	private int tId;
	private int buyerId;
	private String buyerName; 
	private int sellerId;
	private String sellerName;
	private int bId;
	private String bookName;
	private Date start;
	private Date end;
	private String sendTo;
	private String description;
	private int status;
	private String lName;
	private String lNum;
	private int isInfoExist;
	private List<String> lInfo;
	private String book_src;
	private int grade;
	
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
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlNum() {
		return lNum;
	}
	public void setlNum(String lNum) {
		this.lNum = lNum;
	}
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public void setTrade(Trade trade) {
		this.tId = trade.gettId();
		this.buyerId = trade.getBuyerId();
		this.buyerName = trade.getBuyerName();
		this.sellerId = trade.getSellerId();
		this.sellerName = trade.getSellerName();
		this.bId = trade.getbId();
		this.bookName = trade.getBookName();
		this.start = trade.getStart();
		this.end = trade.getEnd();
		this.sendTo = trade.getSendTo();
		this.description = trade.getDescription();
		this.status = trade.getStatus();
		this.grade = trade.getGrade();
	}
	public int getIsInfoExist() {
		return isInfoExist;
	}
	public void setIsInfoExist(int isInfoExist) {
		this.isInfoExist = isInfoExist;
	}
	public List<String> getlInfo() {
		return lInfo;
	}
	public void setlInfo(List<String> lInfo) {
		this.lInfo = lInfo;
	}
	public String getBook_src() {
		return book_src;
	}
	public void setBook_src(String book_src) {
		this.book_src = book_src;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
