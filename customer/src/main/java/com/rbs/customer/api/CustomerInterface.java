/**
 * 
 */
package com.rbs.customer.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rbs.customer.model.Customer;

/**
 * @author Satish
 *
 */

public interface CustomerInterface {
	
		@GetMapping("customers/{customerId}")
	    public ResponseEntity<Customer> findCustomerById(@PathVariable(value = "customerId") Long customerId);
	 	
	 	@PostMapping("customers")
	    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer);
	 	
	 	@PutMapping("customers/{customerId}")
	 	public ResponseEntity<Customer>updateCustomer(@PathVariable(value = "customerId") Long customerId,@RequestBody Customer customer);
	 	
	 	@DeleteMapping("customers/{customerId}")
	 	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") Long customerId);

		
	 	
}
