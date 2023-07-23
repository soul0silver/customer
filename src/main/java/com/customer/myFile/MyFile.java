package com.customer.myFile;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "my_file")
public class MyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private int uid;
    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false,length = 20971520)
    @Lob
    private byte[] content;
}
