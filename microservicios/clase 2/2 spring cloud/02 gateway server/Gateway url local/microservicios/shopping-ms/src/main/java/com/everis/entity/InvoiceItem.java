package com.everis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor @Builder
public class InvoiceItem  {
   
    private Long id;
    private Double quantity;
    private Double  price;
    private Long productId;    
    private Double subTotal;

    public InvoiceItem(Long id, Double quantity, Double  price,Long productId){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;    
    }
    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;
    }
}