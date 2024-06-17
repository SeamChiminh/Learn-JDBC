package model.service;

import model.dto.CustomerDto;
import model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> queryAllCustomer();
    Customer updateCustomerById(Integer id);
    Customer deleteCustomerById(Integer id);
    void addNewCustomer(CustomerDto customerDto);
    CustomerDto searchProductById(Integer id);
}
