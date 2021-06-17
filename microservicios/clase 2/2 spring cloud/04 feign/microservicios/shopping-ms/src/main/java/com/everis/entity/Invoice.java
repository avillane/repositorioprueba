package com.everis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.everis.model.Customer;

@Data
@AllArgsConstructor @Builder
public class Invoice {

    private Long id;

    private String numberInvoice;

    private String description;

    private Long customerId;

    private Date createAt;

    private List<InvoiceItem> items;

    private String state;
    
    private Customer customer;
    
    public Invoice(){
        items = new ArrayList<>();
    }

	public Invoice(long id, String numberInvoice, String description, long customerId, Date createAt, List<InvoiceItem> items, String state) {
		this.id = id;
		this.numberInvoice = numberInvoice;
		this.description = description;
		this.customerId = customerId;
		this.createAt = createAt;
		this.items =items;
		this.state = state;
		//customer = new Customer();
		items = new ArrayList<>();
	}   

}