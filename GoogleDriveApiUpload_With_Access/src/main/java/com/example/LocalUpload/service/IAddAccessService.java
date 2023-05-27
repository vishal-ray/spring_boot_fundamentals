package com.example.LocalUpload.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface IAddAccessService {
    public String addAccess(String fileID, String emailID) throws GeneralSecurityException, IOException;
}
