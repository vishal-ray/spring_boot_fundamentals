package com.example.LocalUpload.Local;

import com.example.LocalUpload.service.GoogleDriveService;
import com.example.LocalUpload.service.IGoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.GeneralSecurityException;

@RestController
public class FileController {
    @Autowired
    public IGoogleDriveService igoogleDriveService;

@PostMapping("/upload")
    public @ResponseBody String UploadFile(@RequestParam("file") MultipartFile file) throws IOException, GeneralSecurityException {

    String filepath="/home/vishal_ray/Downloads";
    Files.copy(file.getInputStream(), Paths.get(filepath+ File.pathSeparator +file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        igoogleDriveService.upload(file);

        return "successfully uploaded";
    }

}
