package software.nju.edu.util;

import java.io.File;

public class UploadFileUtil {
	
	public void upload() {
		String savePath = "";
		File file = new File(savePath);
		
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
			
		}
		
	}

}
