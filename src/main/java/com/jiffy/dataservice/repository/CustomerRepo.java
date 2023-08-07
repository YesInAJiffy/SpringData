package com.jiffy.dataservice.repository;



import com.jiffy.dataservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    // Additional custom query methods can be defined here if needed

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}