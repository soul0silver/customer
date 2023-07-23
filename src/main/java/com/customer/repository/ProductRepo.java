package com.customer.repository;

import com.customer.model.Product;
import com.customer.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into product values(:id,:cid,:pname)",nativeQuery = true)
    void insertP(@Param("id") int id,@Param("cid") int cid,@Param("pname") String pname);
    @Query(value = "select p.* from product as p",nativeQuery = true)
    List<Map<String,Object>> findAllByCid();

}
