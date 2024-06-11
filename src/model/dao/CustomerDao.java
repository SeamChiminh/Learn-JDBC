package model.dao;

import model.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> queryAllCustomers();
    int updateCustomerById(Integer id);
    int deleteCustomerById(Integer id);
    int addNewCustomer(Customer customer);
}