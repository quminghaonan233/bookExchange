package software.nju.edu.domain.entity;

public class User {
	
	private int uId; // user id 唯一标识
	private String userName; // user name
	private String password; // password
	private int score; // user score
	private int credit; // user credit
	
	public User() {
		
	}
	
	public User(int uId, String userName, int score, int credit) {
		this.uId = uId;
		this.userName = userName;
		this.score = score;
		this.credit = credit;
	}
	
	/**
	 * getters and setters
	 * 
	 */
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + uId +
				"userName=" + userName +
				"score=" + score +
				"credit=" + credit +
				"}";
	}
	
	
	
	
	

}
