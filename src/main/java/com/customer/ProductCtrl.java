package com.customer;

import com.customer.model.Product;
import com.customer.repository.ProductRepo;
import com.customer.serrvice.customerServiceImp.ProductSvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductCtrl {
    @Autowired
    ProductSvImp productSvImp;
    @Autowired
    ProductRepo productRepo;
    @GetMapping("/get")
    @Transactional
    public String getAll(Model model) throws Exception {
       productRepo.insertP(1,2,"aaa");
        productRepo.insertP(1,2,"aaa");
        productRepo.insertP(1,2,"aaa");
        productRepo.insertP(1,2,"aaa");
        return "product/list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        productSvImp.save(product);
        return "redirect:product/list";

    }
    @GetMapping("/create/{id}")
    public String update(@PathVariable int id,Model model){
        Product product=productSvImp.findById(id);
        model.addAttribute("p",product);
        return "product/create";
    }
    @GetMapping("/create")
    public String create(Model model){
        Product product=new Product();
        model.addAttribute("p",product);
        return "product/create";
    }
    @GetMapping("/delete/{id}")
    public String del(@PathVariable int id){
        productSvImp.delete(id);
        return "redirect:product/list";
    }

}
