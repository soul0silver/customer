package com.customer;

import com.customer.myFile.MyFile;
import com.customer.repository.FileRepo;
import com.customer.serrvice.customerServiceImp.FileSvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
public class FileCtrl {
    @Autowired
    FileSvImp fileSvImp;
    @GetMapping("/getf/{uid}")
    public ResponseEntity<?> downloadFile(@PathVariable int uid){
        MyFile file=fileSvImp.findByUid(uid);

        return ResponseEntity.status(200).contentType(MediaType.parseMediaType(file.getContentType())).body(file.getContent());
    }
}
