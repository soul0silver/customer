package com.customer.serrvice;

import com.customer.myFile.MyFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileSev {
    MyFile findByName(String fname);
    MyFile findByUid(int uid);
    void saveFile(MultipartFile file,int uid);
}
