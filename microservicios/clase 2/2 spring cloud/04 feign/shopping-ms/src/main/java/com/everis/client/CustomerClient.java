package com.everis.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.model.Customer;

@FeignClient("customer-ms")
@RequestMapping("/customers")
//@FeignClient(name = "customer-ms", url = "localhost:8082")
public interface CustomerClient {
	@GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
   
}
