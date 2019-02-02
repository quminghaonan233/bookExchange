package software.nju.edu.domain.entity;

public class TradeCancel {
	private int tcId; // primary key
	private int tId; // Fk
	private int initiate; // fk uId
	private String description;
	private int status;

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

	public int getInitiate() {
		return initiate;
	}

	public void setInitiate(int initiate) {
		this.initiate = initiate;
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

}
