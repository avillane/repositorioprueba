package com.everis.repository;

import com.everis.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository  {
    public Invoice findByNumberInvoice(String numberInvoice);
    
    public List<Invoice> findAll();
    public <S extends Invoice> S save(S entity);
    public Optional<Invoice> findById(Long id) ;
}
