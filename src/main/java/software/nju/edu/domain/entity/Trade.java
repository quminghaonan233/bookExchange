package software.nju.edu.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class Trade implements Serializable {
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;

	private int tId;
	private int buyer; // foreign key: uId
	private int bId; // foreign key: bId
	private Date start;
	private Date end;
	private String sendTo;
	private String description;
	private int status;

	// constructor without argument.
	public Trade() {

	}

	// constructor with several arguments.
	public Trade(int tId, int buyer, int bId) {
		this.tId = tId;
		this.buyer = buyer;
		this.bId = bId;
	}

	@Override
	public String toString() {
		return "Trade{" + 
				"tId=" + tId +
				"buyer=" + buyer +
				"bId=" + bId +
				"start" + start +
				"end" + end +
				"sendTo" + sendTo +
				"status" + status +
				"}";
		
	}
	
	// getters and setters
	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
