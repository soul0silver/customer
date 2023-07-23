package com.customer.serrvice.customerServiceImp;

import com.customer.model.Customer;
import com.customer.serrvice.customerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("svimp")
public class cusServiceImp implements customerService{

       public ArrayList<Customer> customers = new ArrayList<Customer>();

    public cusServiceImp() {

    }

    public void checkList() {
        if (customers.isEmpty()) {
            customers.add(new Customer(1, "dat", "12/12/12", "09000", 1));
            customers.add(new Customer(1, "dat", "12/12/12", "09000", 2));
            customers.add(new Customer(1, "dat", "12/12/12", "09000", 3));
        }
        }



        public ArrayList<Customer> read() {
            checkList();
            return customers;
        }

    @Override
    public void create(Customer customers) {
        checkList();
        customers.setCuId(this.customers.size()+1);
        this.customers.add(customers);

    }
    @Override
    public void update(Customer customers) {
        for ( Customer c: this.customers) {
            c.setCuName(customers.getCuName());
            c.setbDay(customers.getbDay());
            c.setPhone(customers.getPhone());
            c.setaId(customers.getaId());
        }

    }

    @Override
    public void checkID(Customer customer) {
        if (customer.getCuId()==0){
            create(customer);
        }else {
            update(customer);
        }

    }

    @Override
    public Customer findById(int id) {
        Customer c=new Customer();
        for (int i=0;i<customers.size();i++)
            if (customers.get(i).getCuId()==id) {
                 c= customers.get(i);break;
            }
        return c;
        }

    @Override
    public void delete(Customer customer) {
        checkList();
        for (int i=0;i<customers.size();i++)
            if (customers.get(i).equals(customer))
                customers.remove(i);
    }
}

