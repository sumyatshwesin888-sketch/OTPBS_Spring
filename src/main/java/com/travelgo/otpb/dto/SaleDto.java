package com.travelgo.otpb.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travelgo.otpb.domain.Sale;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;
import com.travelgo.otpb.util.DateTimeFormatSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(value = Include.USE_DEFAULTS)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {


    private int saleId;

    private Integer userAccountId;
    private ProductDto  product;

    private int customerId;
    private UserAccountDto customer;
    
    private int productId;

    private String voucherCode;

    private int qty;

    private int unitPrice;

    private int amount;

    private String paymentType;

    private String status;
    
    
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
    private Date date;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
    private Date modifiedDate;

	public void setProductDto(ProductDto product) {
		// TODO Auto-generated method stub
		this.product = product;
		
	}
	public SaleDto(int saleId, int userAccountId, int customerId, String voucherCode, int qty, int unitPrice,
			int amount, String paymentType) {
		// TODO Auto-generated constructor stub
		this.saleId = saleId;
		this.userAccountId = userAccountId;
		this.customerId = customerId;
		this.voucherCode=voucherCode;
		this.qty = qty;
		this.unitPrice=unitPrice;
		this.amount = amount;
		this.paymentType=paymentType;
		
	}
	public SaleDto(Sale sale) {
		// TODO Auto-generated constructor stub
		this.saleId = sale.getSaleId();
	    this.userAccountId = sale.getUserAccountId();
	    this.customerId = sale.getCustomerId();
	    this.productId = sale.getProductId();
	    this.voucherCode = sale.getVoucherCode();
	    this.qty = sale.getQty();
	    this.unitPrice = sale.getUnitPrice();
	    this.amount = sale.getAmount();
	    this.paymentType = sale.getPaymentType();
	    this.status = sale.getStatus();
	    this.date = sale.getDate();
	    this.modifiedDate = sale.getModifiedDate();
	}

	public SaleDto(int saleId,int userAccountId, int customerId, String profileName, int productId, String title, int qty,
			int unitPrice, int amount, String paymentType, String status, Date date, Date modifiedDate,
			String voucherCode) {
		// TODO Auto-generated constructor stub
		this.saleId = saleId;
		this.userAccountId = userAccountId;
		this.customer = new UserAccountDto(customerId,profileName);
		this.product = new ProductDto(productId,title);
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.paymentType = paymentType;
		this.status = status;
		this.date = date;
		this.modifiedDate = modifiedDate;
		this.voucherCode = voucherCode;
	}


}


