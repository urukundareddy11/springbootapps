package com.rbs.customer.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbs.customer.model.Customer;

public class CustomerRepositoryImpl {

	@Autowired
	private CustomerRepository customerRepository;	

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Optional<Customer> findCustomerById(Long customerId) {
		return customerRepository.findById(customerId);
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);		
	}

}
