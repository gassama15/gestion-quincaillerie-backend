package sn.simplon.quincaillerie.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class FileUploadController {
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	@PostMapping("/new")
	public ResponseEntity<Object> fileUpload(@RequestParam("image") MultipartFile file) throws IOException {
		File myFile = new File("src/main/resources/static/upload/"+file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		
		return new ResponseEntity<Object>("The File uploaded successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<Object> deleteImage(@PathVariable("name") String name) {
		File deleter = new File("src/main/resources/static/upload/"+name);
		deleter.delete();
		return new ResponseEntity<Object>("The File deleted successfully", HttpStatus.OK);
	}

}
