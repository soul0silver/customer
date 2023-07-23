package com.customer.serrvice;

import com.customer.model.Customer;

import java.util.ArrayList;

public interface customerService {
    public void create(Customer customers);

    public void update(Customer customers);

    public void checkID(Customer customer);
    public Customer findById(int id);
    public ArrayList<Customer> read();
    public void delete(Customer customer);
}