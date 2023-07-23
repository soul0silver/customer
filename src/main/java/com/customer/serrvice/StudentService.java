package com.customer.serrvice;

import com.customer.model.Customer;
import com.customer.model.Student;
import com.customer.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    public Student create(Student student);

    public void update(Student student);

    public void checkID(Student student);
    public Student findById(int id);
    public ArrayList<StudentDTO> read();
    public void delete();
    public List<Student> findByAid(int aid);
}
