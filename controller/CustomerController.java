package HotelManagement.controller;

import HotelManagement.model.Customer;
import HotelManagement.service.CustomerService;
import HotelManagement.util.InputUtil;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void addCustomer() {

        String custName = InputUtil.getString("Enter Customer Name: ");
        String email = InputUtil.getString("Enter Email: ");
        String phoneNumber = InputUtil.getString("Enter Phone Number: ");
        String address = InputUtil.getString("Enter Full Address: ");
        String idProof = InputUtil.getString("Enter IdProof: ");

        customerService.addCustomer(new Customer(custName, email, phoneNumber, address, idProof));

        System.out.println("Customer Added Successfully");
    }

    public void getCustomerById() {
        int custId = InputUtil.getInt("Enter Customer Id: ");

        Customer customer = customerService.getCustomerById(custId);

        if (customer == null) {
            System.out.println("Customer Not Found!");
        } else {
            System.out.println("Customer Found");
            System.out.println(customer);
        }
    }

    public void updateCustomer() {
        int custId = InputUtil.getInt("Enter Customer Id: ");
        Customer existing = customerService.getCustomerById(custId);

        if(existing == null){
            System.out.println("Customer not found!");
            return;
        }

        String custName = InputUtil.getString("Enter Customer Name: ");
        String email = InputUtil.getString("Enter Email: ");
        String phoneNumber = InputUtil.getString("Enter Phone Number: ");
        String address = InputUtil.getString("Enter Full Address: ");
        String idProof = InputUtil.getString("Enter IdProof: ");

        customerService.updateCustomer(new Customer(custId, custName, email, phoneNumber, address, idProof));
        System.out.println("Customer Updated Successfully");
    }


    public void getAllCustomers() {
        System.out.println("List Of Customers: ");
        customerService.listAllCustomers().forEach(System.out::println);
    }

}
