package software.nju.edu.util;

import java.io.File;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class UploadFileUtil {
	
	public void upload() {
		String savePath = "";
		File file = new File(savePath);
		
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
			
		}
		
	}

}
