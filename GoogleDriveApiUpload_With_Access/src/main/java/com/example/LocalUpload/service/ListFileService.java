package com.example.LocalUpload.service;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class ListFileService implements IListFileService{

    @Autowired
    public IGoogleDriveService iGoogleDriveService;
    public List<File> listFolderContent(String parentId) throws IOException, GeneralSecurityException {
        if(parentId == null){
            parentId = "root";
        }
        String query = "'" + parentId + "' in parents";
        FileList result = iGoogleDriveService.getDrive().files().list()
                .setQ(query)
                .setPageSize(20)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return result.getFiles();
    }
}
