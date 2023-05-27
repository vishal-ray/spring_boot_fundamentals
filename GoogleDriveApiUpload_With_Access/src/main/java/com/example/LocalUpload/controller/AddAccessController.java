package com.example.LocalUpload.controller;

import com.example.LocalUpload.LocalUploadApplication;
import com.example.LocalUpload.service.IAddAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;


@RestController
public class AddAccessController {
    @Autowired
    public IAddAccessService iAddAccessService;
    private static final Logger log = LoggerFactory.getLogger(LocalUploadApplication.class);
    @PostMapping(value = "/addaccess")
    public ResponseEntity<String> addAccess(@RequestParam(required = true) String fileId, String emailID) throws GeneralSecurityException, IOException {
        iAddAccessService.addAccess(fileId,emailID);
        return ResponseEntity.ok("FileID : " + fileId + "Shareable Link : drive.google.com/file/d/" + fileId + "/view?usp=sharing");
    }
}
