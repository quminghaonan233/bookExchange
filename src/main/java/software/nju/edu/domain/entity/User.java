package software.nju.edu.domain.entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attributes
	 */
	private int uId; // user id 唯一标识
	private String userName; // user name
	private String passwd; // password
	private int score; // user score
	private int credit; // user credit
	
	// constructor without argument.
	public User() {
		
	}
	
	// constructor with several arguments.
	public User(int uId, String userName, int score, int credit) {
		this.uId = uId;
		this.userName = userName;
		this.score = score;
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"userId=" + uId + ", " + 
				"userName=" + userName + ", " + 
				"passwd=" + "******" + ", " +
				"score=" + score + ", " +
				"credit=" + credit+
				"}";
	
	}
	
	// getters and setters
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

}
