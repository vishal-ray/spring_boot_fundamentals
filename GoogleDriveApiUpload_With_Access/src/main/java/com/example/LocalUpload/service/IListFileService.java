package com.example.LocalUpload.service;

import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface IListFileService {
    public List<File> listFolderContent(String parentId) throws IOException, GeneralSecurityException;

}
