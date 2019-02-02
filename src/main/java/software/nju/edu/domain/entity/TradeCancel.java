package software.nju.edu.domain.entity;

import java.io.Serializable;

public class TradeCancel implements Serializable {
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attributes
	 */
	private int tcId;          // Primary key
	private int tId;           // Foreign key tId
	private int sourceId;      // Foreign key uId
	private String sourceName;
	private int targetId;      // Foreign key uId
	private String targetName;
	private String cancelDescription;
	private int cancelStatus;
	private String tradeDescrpition;
	private int tradeStatus;
	private String bookName;
	
	/**
	 * getters and setters
	 * 
	 */
	public int getTcId() {
		return tcId;
	}
	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public String getTarhetName() {
		return targetName;
	}
	public void setTarhetName(String tarhetName) {
		this.targetName = tarhetName;
	}
	public String getCancelDescription() {
		return cancelDescription;
	}
	public void setCancelDescription(String cancelDescription) {
		this.cancelDescription = cancelDescription;
	}
	public int getCancelStatus() {
		return cancelStatus;
	}
	public void setCancelStatus(int cancelStatus) {
		this.cancelStatus = cancelStatus;
	}
	public String getTradeDescrpition() {
		return tradeDescrpition;
	}
	public void setTradeDescrpition(String tradeDescrpition) {
		this.tradeDescrpition = tradeDescrpition;
	}
	public int getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}	

}
