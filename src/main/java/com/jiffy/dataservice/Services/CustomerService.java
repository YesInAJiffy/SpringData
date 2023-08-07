package com.jiffy.dataservice.Services;


import com.jiffy.dataservice.entity.Customer;
import com.jiffy.dataservice.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo CustomerRepo) {
        this.customerRepo = CustomerRepo;
    }

    // Implement business logic using repository methods
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer Customer) {
        return customerRepo.save(Customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}