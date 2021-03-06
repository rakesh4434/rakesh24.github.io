/*package com.tcs.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.repository.PhotoTblRepository;
import com.tcs.org.exception.FileStorageException;
import com.example.filedemo.exception.MyFileNotFoundException;
import com.example.filedemo.model.DBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@Service
public class PhotoTblService {
	
	@Autowired
    private PhotoTblRepository photoTblRepository;
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
        // Check if the file's name contains invalid characters
        if(fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

        return dbFileRepository.save(dbFile);
    } catch (IOException ex) {
        throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
}

public DBFile getFile(String fileId) {
    return dbFileRepository.findById(fileId)
            .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
}
}

}
*/