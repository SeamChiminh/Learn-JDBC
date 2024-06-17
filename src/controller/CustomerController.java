package controller;

import model.dto.CustomerDto;
import model.entity.Customer;
import model.service.CustomerService;
import model.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();
    public void addNewCustomer(CustomerDto customerDto) {
        customerService.addNewCustomer(customerDto);
    }

    public List<CustomerDto> queryAllCustomers() {
        return customerService.queryAllCustomer();
    }

    public void searchCustomerById(Integer id) {
        customerService.searchProductById(id);
    }

    public void deleteCustomerById(Integer id) {
        customerService.deleteCustomerById(id);
    }

    public void updateCustomerById(Integer id) {
        customerService.updateCustomerById(id);
    }
}
