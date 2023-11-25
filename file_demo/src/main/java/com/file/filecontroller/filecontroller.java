package com.file.filecontroller;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.payload.fileresponse;
import com.file.service.fileservice;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class filecontroller {

    @Autowired
    private fileservice fileservice;

    @Value("${project.image:images/}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<fileresponse> uploadimage(@RequestParam("image") MultipartFile image) {
        String filename = null;
        try {
            filename = fileservice.uplpoadimage(path, image);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new fileresponse(null, "Image is not uploaded due to some error."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new fileresponse(filename, "Image is successfully uploaded."), HttpStatus.OK);
    }
    
    
    @GetMapping("/upload/{imagename}")
    public void downloadimage(@PathVariable("imagename") String imagename,HttpServletResponse response) throws IOException {
    	
    	   // Ensure the file extension is included in the image name
        String fullImageName = imagename + ".jpg";

        InputStream resource = this.fileservice.getresource(path, fullImageName);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    	
    	
    }
}
