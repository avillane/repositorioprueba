package com.everis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Invoice(){
        items = new ArrayList<>();
    }   

}