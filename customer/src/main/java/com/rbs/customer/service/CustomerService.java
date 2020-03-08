package com.rbs.customer.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rbs.customer.model.Customer;
import com.rbs.customer.repository.CustomerRepositoryImpl;

@Service
public class CustomerService {

	private CustomerRepositoryImpl customerRepository;

	public CustomerService(CustomerRepositoryImpl customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.saveCustomer(customer);
	}

	public Optional<Customer> findCustomerById(Long customerId) {
		return customerRepository.findCustomerById(customerId);
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.deleteCustomer(customer);
	}

}
