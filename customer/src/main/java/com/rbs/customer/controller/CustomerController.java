package com.rbs.customer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.customer.api.CustomerInterface;
import com.rbs.customer.exception.ResourceNotFoundException;
import com.rbs.customer.model.Customer;
import com.rbs.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController implements CustomerInterface {

	@Autowired
	private CustomerService customerService;

	public ResponseEntity<Customer> findCustomerById(@PathVariable Long customerId) {
		return new ResponseEntity(customerService.findCustomerById(customerId), HttpStatus.OK);
	}

	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId,
			@RequestBody Customer customerDetails) {
		Customer customer = null;
		try {
			customer = customerService.findCustomerById(customerId).orElseThrow(
					() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		if (customer != null) {
			customer.setCustomerName(customerDetails.getCustomerName());
			customer.setCustomerMobile(customerDetails.getCustomerMobile());
			customer.setCity(customerDetails.getCity());
			customer.setState(customerDetails.getState());
			customer.setCountry(customerDetails.getCountry());
		}
		final Customer updateCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(updateCustomer);

	}

	@Override
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
		Customer customer = null;
		try {
			customer = customerService.findCustomerById(customerId).orElseThrow(
					() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		customerService.deleteCustomer(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}
