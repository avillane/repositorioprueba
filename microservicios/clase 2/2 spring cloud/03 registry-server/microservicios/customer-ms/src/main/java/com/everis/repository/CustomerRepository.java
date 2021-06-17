package com.everis.repository;

import com.everis.entity.Customer;
import com.everis.entity.Region;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository  {
        public Customer findByNumberID(String numberID);
        public List<Customer> findByRegion(Region region);
        
        public List<Customer> findAll();
        public <S extends Customer> S save(S entity);
        public Optional<Customer> findById(Long id);
}
