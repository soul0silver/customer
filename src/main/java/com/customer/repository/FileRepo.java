package com.customer.repository;

import com.customer.myFile.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<MyFile,Integer> {
    MyFile findFileByFname(String fName);
    MyFile findFileByUid(int uid);
}
