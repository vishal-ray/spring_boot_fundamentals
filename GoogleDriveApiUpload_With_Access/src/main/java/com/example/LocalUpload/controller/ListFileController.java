package com.example.LocalUpload.controller;

import com.example.LocalUpload.service.IGoogleDriveService;
import com.example.LocalUpload.service.IListFileService;
import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class ListFileController {
    @Autowired
    public IListFileService iListFileService;

    @GetMapping({"/list","/list/{parentId}"})
    public ResponseEntity<List<File>> list(@PathVariable(required = false) String parentId) throws IOException, GeneralSecurityException {
        List<File> files = iListFileService.listFolderContent(parentId);
        return ResponseEntity.ok(files);
    }
}
