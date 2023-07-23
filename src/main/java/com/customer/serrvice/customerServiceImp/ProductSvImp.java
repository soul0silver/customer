package com.customer.serrvice.customerServiceImp;

import com.customer.model.Product;
import com.customer.model.ProductDto;
import com.customer.repository.ProductRepo;
import com.customer.serrvice.ProductSV;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class ProductSvImp implements ProductSV {
   @Autowired
   ProductRepo productRepo;
   @PersistenceUnit
   private EntityManagerFactory factory;
    private EntityManager entityManager;
    private EntityTransaction transaction;



    @Override
    @Transactional
    public void create() {

    }

    @Override
    public List<Product> read() throws Exception {
        List<Product>products= productRepo.findAll();
        if (products.isEmpty()) throw new NullPointerException();
        return  products;
    }

    @Override
    public Product  findById(int id) {
        Optional<Product> product=productRepo.findById(id);
        if (product.isEmpty()) throw new NullPointerException();
        return product.get();
    }

    @Override
    @Transactional
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void   save(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<ProductDto> findByCate() {
        List<Map<String,Object>> mapList=productRepo.findAllByCid();
        ObjectMapper mapper=new ObjectMapper();
        List<ProductDto> productDtos= new ArrayList<ProductDto>();
        for (Map m: mapList)
        {
            ProductDto productDto=mapper.convertValue(m,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }



}
