package software.nju.edu.domain.association;

public class TradeCancel {
	private int tId; // Fk
	private int initiate;  // fk uId
	private String description;
	private int status;
	
	/**
	 * getters and setters
	 * 
	 */
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
