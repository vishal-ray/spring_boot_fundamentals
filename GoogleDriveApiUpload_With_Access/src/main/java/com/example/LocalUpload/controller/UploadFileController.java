package com.example.LocalUpload.controller;

import com.example.LocalUpload.LocalUploadApplication;
import com.example.LocalUpload.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class UploadFileController {
    @Autowired
    public IUploadFileService iUploadFileService;
    private static final Logger log = LoggerFactory.getLogger(LocalUploadApplication.class);
    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadSingleFileExample4(@RequestBody MultipartFile file, @RequestParam(required = false) String path, String emailID) {
        log.info("Request contains, File: " + file.getOriginalFilename());
        String fileId = iUploadFileService.uploadFile(file, path, emailID);
        if(fileId == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("FileID : " + fileId + "Shareable Link : drive.google.com/file/d/" + fileId + "/view?usp=sharing");
    }
}
