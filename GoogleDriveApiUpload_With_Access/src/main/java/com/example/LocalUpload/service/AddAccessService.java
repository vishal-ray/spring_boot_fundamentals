package com.example.LocalUpload.service;

import com.example.LocalUpload.LocalUploadApplication;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;



@Service
public class AddAccessService implements IAddAccessService{
    @Autowired
    public IGoogleDriveService iGoogleDriveService;

   public String addAccess(String fileID, String emailID) throws GeneralSecurityException, IOException {
       Permission permission = new Permission();
       permission.setType("user")
               .setRole("reader")
               .setEmailAddress(emailID);
       iGoogleDriveService.getDrive()
               .permissions()
               .create(fileID,permission)
               .execute();
       return fileID;
   }

}
