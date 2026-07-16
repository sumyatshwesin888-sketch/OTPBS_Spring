package com.travelgo.otpb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.util.ConvertDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor
@AllArgsConstructor 

@Entity
@Table(name = "sale")
public class Sale {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;

    private Integer userAccountId;

    private int customerId;

    private int productId;

    private String voucherCode;

    private int qty;

    private int unitPrice;

    private int amount;

    private String paymentType;

    private String status;

    private Date date;

    private Date modifiedDate;

	

    public Sale(SaleDto dto) {
		// TODO Auto-generated constructor stub
    	
    	this.saleId = dto.getSaleId();//
    	this.userAccountId = dto.getUserAccountId();//
    	this.customerId = dto.getCustomerId();
    	this.productId = dto.getProduct().getProductId();
    	this.voucherCode = ConvertDate.createVoucherCode(new Date());//
    	this.qty = dto.getQty();
    	this.unitPrice = dto.getUnitPrice();
    	this.amount = this.qty*this.unitPrice;
    	this.paymentType = dto.getPaymentType();
    	this.status  = "CONFIRM";
    	this.date = new Date();
    	this.modifiedDate = new Date();
	}

	
    
}