package HotelManagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HotelManagement.model.Customer;
import HotelManagement.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Customer getCustomerById(int custId) {
        return  customerRepository.getCustomerById(custId);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public List<Customer> listAllCustomers() {
        return  customerRepository.getAllCustomer();
    }

}
