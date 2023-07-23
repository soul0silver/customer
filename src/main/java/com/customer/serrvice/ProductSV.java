package com.customer.serrvice;

import com.customer.model.Product;
import com.customer.model.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductSV {
     void create();
    List<Product> read() throws Exception;
    Product  findById(int id);
    void   delete(int id);
    void   save (Product product);
    List<ProductDto>  findByCate();

}
