package com.customer.serrvice.customerServiceImp;

import com.customer.model.Address;
import com.customer.model.Student;
import com.customer.model.StudentDTO;
import com.customer.repository.StudentRepo;
import com.customer.serrvice.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Component
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @PersistenceUnit
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Override
    public Student create(Student student) {
      return   studentRepo.save(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void checkID(Student student) {

    }

    @Override
    public Student findById(int id) {
        entityManager = factory.createEntityManager();
        transaction = entityManager.getTransaction();
        Student student=entityManager.find(Student.class,id);
        return student;
    }
    public List<Student> findByAid(int aid){
        entityManager = factory.createEntityManager();
//        String queryHQL="select s from Student as s where s.aid=?1";
        String querySQL="select * from Student where aid=?1";
//        List<Student> list1=entityManager.createNativeQuery(queryHQL,Student.class)
//                .setParameter(1,aid).getResultList();
        List<Student> list=entityManager.createNativeQuery(querySQL,Student.class)
                .setParameter(1,aid).getResultList();
        return list;
    }
    @Override
    public ArrayList<StudentDTO> read() {
        entityManager = factory.createEntityManager();
        transaction = entityManager.getTransaction();
        ArrayList<StudentDTO> list = (ArrayList<StudentDTO>) entityManager.createNativeQuery("select s.* ,a.province from Student as s,address as a where s.aid=a.aid", StudentDTO.class).getResultList();

        if (list.isEmpty()) return null;
        return list;
    }

    @Override
    public void delete() {

    }
}
