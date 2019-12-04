package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping("fileUploadForm.do")
	public String fileUploadForm() {
		return "fileUploadForm";
	}
	@RequestMapping("fileUpload.do")
	public String fileUpload(MultipartFile attached_file) {
		File file = new File("/Users/student/"+attached_file.getOriginalFilename());
		try {
			attached_file.transferTo(file);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(attached_file.getOriginalFilename());
		
		return "redirect:fileUploadForm.do";
	}
}
