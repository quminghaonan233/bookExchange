package software.nju.edu.util;

import java.util.UUID;

public class UUIDUtil {
	
	public UUIDUtil() {
		
	}
	
	public String getUUID() {
		
		String uuid = UUID.randomUUID().toString();
		
		return uuid;
		
	}

}
