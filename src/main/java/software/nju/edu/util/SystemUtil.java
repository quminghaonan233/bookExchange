package software.nju.edu.util;

public class SystemUtil {
	
	public String getSystemType() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows"))
			return "Windows";
		else if (osName.contains("Mac OS")) 
			return "Mac OS";
		else if (osName.contains("Linux"))
			return "Linux";
		
		return "Linux";
	}
	
	public static void main(String[] args) {
		String res = new SystemUtil().getSystemType();
		System.out.println(res);
	}

}
