package com.customer;

import com.customer.model.Customer;
import com.customer.serrvice.customerServiceImp.cusServiceImp;
import com.customer.serrvice.dao.CustomerDao;
import com.customer.test.ClassA;
import com.customer.test.ClassC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/customer",method = RequestMethod.POST)
public class customerController {
    public final ClassC c;
    public final CustomerDao dao;
    cusServiceImp cusServiceImp;

    public customerController(ClassC c, CustomerDao dao) {
        this.c = c;
        this.dao = dao;
    }

    @GetMapping("/home")
    public String getHome(Model model,@CookieValue(value = "username",defaultValue = "") String username,@CookieValue(value = "us2",defaultValue = "") String us2,@SessionAttribute ("username-ss") String username1) {
        ArrayList<Customer> customersList = dao.read();
        model.addAttribute("list", customersList);
        System.out.println(username);
        System.out.println(us2);
        System.out.println(username1);

        return "customer/home";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create";
    }

    @PostMapping("/save")
    public String postCreate(@ModelAttribute Customer customer) {
        dao.create(customer);
        return "redirect:/customer/home";
    }

    //
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable int id) {
        Customer customer = dao.findById(id);
        model.addAttribute("customer", customer);
        return "customer/update";

    }
    @Autowired
    ClassA a;
    @GetMapping("/test")
    public String postCreat() {
        a.getHl();
        System.out.println(a);
        ClassA classA=a;
        System.out.println(classA);

        return "/customer/home";
    }
}
