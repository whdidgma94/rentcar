package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminImgUploadController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UPLOAD_DIR = "img";
		String saveFolder = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File isDir = new File(saveFolder); 
		if (!isDir.isDirectory()) {
			isDir.mkdir();
		}
		int maxSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		MultipartRequest multi = null;

		try {
			multi = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());
			String fileName = multi.getFilesystemName("uploadFile");
			response.setCharacterEncoding("utf-8"); 
			File file = multi.getFile("uploadFile");
			if (file != null) {
				response.getWriter().print(fileName);
			} else {
				response.getWriter().print("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
