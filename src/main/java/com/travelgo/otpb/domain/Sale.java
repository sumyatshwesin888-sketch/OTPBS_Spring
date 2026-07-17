package com.travelgo.otpb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.SaleDto;
import com.travelgo.otpb.util.ConvertDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor 

@Entity
@Table(name = "sale")
public class Sale {
//<<<<<<< HEAD
//=======

	
    public Sale(SaleDto dto) {
		// TODO Auto-generated constructor stub
    	this.saleId = dto.getSaleId();//
    	this.userAccountId = dto.getUserAccountId();//
    	this.customerId = dto.getCustomerId();
    	this.productId = dto.getProductId();
    	this.voucherCode = ConvertDate.createVoucherCode(date);//
    	this.qty = dto.getQty();
    	this.unitPrice = dto.getUnitPrice();
    	this.amount = this.qty*this.unitPrice;
    	this.paymentType = dto.getPaymentType();
    	this.status  = dto.getStatus();
    	this.date = new Date();
    	this.modifiedDate = new Date();
	}

//>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5
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

//<<<<<<< HEAD
	

//    public Sale(SaleDto dto) {
//		// TODO Auto-generated constructor stub
//    	
//    	this.saleId = dto.getSaleId();//
//    	this.userAccountId = dto.getUserAccountId();//
//    	this.customerId = dto.getCustomerId();
//    	this.productId = dto.getProduct().getProductId();
//    	this.voucherCode = ConvertDate.createVoucherCode(new Date());//
//    	this.qty = dto.getQty();
//    	this.unitPrice = dto.getUnitPrice();
//    	this.amount = this.qty*this.unitPrice;
//    	this.paymentType = dto.getPaymentType();
//    	this.status  = "CONFIRM";
//    	this.date = new Date();
//    	this.modifiedDate = new Date();
//	}

	
//=======
	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	

	
//>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5
    
}