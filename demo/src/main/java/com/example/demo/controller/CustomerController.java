package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
   @Autowired
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

@PostMapping
@PreAuthorize("hasRole('client-admin')")
    public ResponseEntity addcustomer(@RequestBody Customer customer){
        customerService.addcustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    @PreAuthorize("hasRole('client-user')")
    public ResponseEntity updatecustomer(@RequestBody Customer customer){
        customerService.updatecustomer(customer);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    @PreAuthorize("hasRole('client-admin')")
    public ResponseEntity<List<Customer>>getAllcustomers(){
        return ResponseEntity.ok(customerService.getAllcustomers());
    }
    public void getCustomerByName(){

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('client-admin')")
    public ResponseEntity deletecustomer(@PathVariable String id){
        customerService.deletecustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
