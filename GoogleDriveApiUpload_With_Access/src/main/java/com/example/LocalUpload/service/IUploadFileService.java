package com.example.LocalUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

    public String uploadFile(MultipartFile file, String filePath, String emailID);
}
