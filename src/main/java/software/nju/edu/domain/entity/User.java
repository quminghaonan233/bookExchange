package software.nju.edu.domain.entity;

public class User {
	
	private String uid; // user_id 唯一标识
	private String uname; // user_name
	private String passwd; // password
	private int upoints; // user points
	
	public User() {
		
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getUpoints() {
		return upoints;
	}

	public void setUpoints(int upoints) {
		this.upoints = upoints;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				"uname=" + uname +
				"upoints=" + upoints +
				"}";
	}
	
	
	
	
	

}
