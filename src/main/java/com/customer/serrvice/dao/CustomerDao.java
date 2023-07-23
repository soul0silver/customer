package com.customer.serrvice.dao;

import com.customer.comm.ConnectJdbc;
import com.customer.model.Customer;
import com.customer.serrvice.customerService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
@Service("svdao")
public class CustomerDao implements customerService {
    private PreparedStatement preparedStatement;
    @Override
    public void create(Customer customers) {
        try {
            int id = (int) (Math.random() * ( 1000 - 1 ));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(simpleDateFormat.parse(customers.getbDay()).getTime());
            preparedStatement = ConnectJdbc.con().prepareStatement("insert into customers value (?,?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,customers.getCuName());
            preparedStatement.setString(3,customers.getbDay());
            preparedStatement.setString(4,customers.getPhone());
            preparedStatement.setInt(5,customers.getaId());
            preparedStatement.execute();
            System.out.println("success!");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            preparedStatement = ConnectJdbc.con().prepareStatement("select*from customers where cusid="+customer.getCuId());
            ResultSet resultSet=preparedStatement.executeQuery();
            int cuIDd =resultSet.getInt(1);
            String cuName=resultSet.getString(2);
            String birth=resultSet.getString(3);
            int aId=resultSet.getInt(5);
            String phone=resultSet.getString(4);
            customer.setCuId(cuIDd);
            customer.setCuName(cuName);
            customer.setbDay(birth);
            customer.setPhone(phone);
            customer.setaId(aId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void checkID(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
       Customer customer =new Customer();
        try {
            String a="select*from customers where cusid="+id;
            preparedStatement = ConnectJdbc.con().prepareStatement("select*from customers where cusid=?");

            ResultSet resultSet=preparedStatement.executeQuery();
            int cuIDd =resultSet.getInt(1);
            String cuName=resultSet.getString(2);
            String birth=resultSet.getString(3);
            int aId=resultSet.getInt(5);
            String phone=resultSet.getString(4);
            customer.setCuId(cuIDd);
            customer.setCuName(cuName);
            customer.setbDay(birth);
            customer.setPhone(phone);
            customer.setaId(aId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    @Override
    public ArrayList<Customer> read() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            preparedStatement = ConnectJdbc.con().prepareStatement("select*from customers");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int cuIDd =resultSet.getInt(1);
                String cuName=resultSet.getString(2);
                String birth=resultSet.getString(3);
                int aId=resultSet.getInt(5);
                String phone=resultSet.getString(4);
                Customer customer=new Customer();
                customer.setCuId(cuIDd);
                customer.setCuName(cuName);
                customer.setbDay(birth);
                customer.setPhone(phone);
                customer.setaId(aId);
                customers.add(customer);
            }return customers;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Customer customer) {

    }
}
