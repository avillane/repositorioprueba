package com.everis.repository;

import com.everis.entity.Invoice;
import com.everis.entity.InvoiceItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

	private List<InvoiceItem> items = new ArrayList<InvoiceItem>();
	private List<Invoice> invoices = new ArrayList<Invoice>();
	
	private void init() {
		InvoiceItem c1 = new InvoiceItem(1L, 1.0, 178.89,1L);
		InvoiceItem c2 = new InvoiceItem(2L, 2.0, 12.5,  2L);
		InvoiceItem c3 = new InvoiceItem(3L, 1.0, 40.06, 3L);
		
		items.add(c1);
		items.add(c2);
		items.add(c3);
				
		Invoice p1 = new Invoice(1L, "001","invoice office items" , 1L, new Date(), items, "CREATED");
	
		invoices.add(p1);

	}
	
	public InvoiceRepositoryImpl( ) {
		init();
	}
	
	@Override
	public List<Invoice> findAll() {
		return invoices;
	}

	@Override
	public Optional<Invoice> findById(Long id) {
		return invoices.stream().filter(p ->   p.getId() == id).findFirst();
	}
	@Override
	public <S extends Invoice> S save(S entity) {
		invoices.add(entity);		
		return entity;
	}
	
	@Override
	public Invoice findByNumberInvoice(String numberInvoice) {
		return invoices.stream().filter(p ->   p.getNumberInvoice().equals(numberInvoice)).findAny().orElse(null);
		
	}
	

}
