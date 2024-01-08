package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

@Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addcustomer(Customer customer){
        customerRepository.insert(customer);

    }
    public void updatecustomer(Customer customer){
        Customer savedcustomer = customerRepository.findById(customer.getID()).orElseThrow(()->new RuntimeException(String.format("Cannot find by ID %s",customer.getID())));
        savedcustomer.setID(customer.getID());
        savedcustomer.setName(customer.getName());
        savedcustomer.setEmail(customer.getEmail());

        customerRepository.save(customer);
    }
    public List<Customer> getAllcustomers(){
        return customerRepository.findAll();
    }
    public void getCustomerByName(){

    }
    public void deletecustomer(String id){
        customerRepository.deleteById(id);
    }
}
