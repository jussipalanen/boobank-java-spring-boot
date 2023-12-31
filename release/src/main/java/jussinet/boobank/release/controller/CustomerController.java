package jussinet.boobank.release.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jussinet.boobank.release.entity.Customer;
import jussinet.boobank.release.repository.CustomerRepository;

/*
 * Customer API
 */
@RestController
@RequestMapping("/api/v1")
public class CustomerController {


    @Autowired
    private CustomerRepository repository;

    CustomerController(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    /**
     * Get all of the customers
     * 
     * @return
     */
    @GetMapping(value = "/customers")
    List<Customer> all() {
        return repository.findAll();
    }

    /**
     * Get a single customer by id
     * 
     * @param id
     * @return
     */
    @GetMapping(value = "/customers/{id}")
    public Optional<Customer> get(@PathVariable int id) {
        return repository.findById(id);
    }


    /**
     * Create a new customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/customers/save")
    public Customer post(Customer customer)
    {
        repository.save(customer);
        return customer;
    }
}
