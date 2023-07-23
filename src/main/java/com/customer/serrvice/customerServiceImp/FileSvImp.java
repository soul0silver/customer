package com.customer.serrvice.customerServiceImp;

import com.customer.myFile.MyFile;
import com.customer.repository.FileRepo;
import com.customer.serrvice.FileSev;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class FileSvImp implements FileSev {
    @Autowired
    FileRepo fileRepo;
    @PersistenceUnit
    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;
    @Override
    public MyFile findByName(String fname) {

        return fileRepo.findFileByFname(fname);
    }

    @Override
    public MyFile findByUid(int uid) {
        return fileRepo.findFileByUid(uid);
    }

    @Override
    public void saveFile(MultipartFile file, int uid) {
        MyFile myFile=new MyFile();
        myFile.setUid(uid);
        try {
            myFile.setFname(file.getOriginalFilename());
            myFile.setContentType(file.getContentType());
            myFile.setContent(file.getBytes());
            fileRepo.save(myFile);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
