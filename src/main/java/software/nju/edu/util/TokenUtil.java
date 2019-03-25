package software.nju.edu.util;

public class TokenUtil {
	private static TokenUtil util;
	
	private TokenUtil() {
		
	}
	
	public static TokenUtil getInstance() {
		if(util == null) {
			util = new TokenUtil();
		}
		return util;
	}
	
	public static String generateToken(int id) {
		return "123";
	}
	
	public static String getuIdbyToken(String token) {
		return "1";
	}
}
