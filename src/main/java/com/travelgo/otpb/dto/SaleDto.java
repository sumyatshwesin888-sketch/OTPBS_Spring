package com.travelgo.otpb.dto;

import java.math.BigDecimal;
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

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    public SaleDto(int saleId, int userAccountId, int customerId,  String voucherCode, int qty, int unitPrice, int amount, String paymentType ,Sale sale) {

        this.saleId = sale.getSaleId();
        this.userAccountId = sale.getUserAccountId();
        this.customerId = sale.getCustomerId();
//        this.product = new ProductDto(sale.getProductId());
        this.voucherCode = sale.getVoucherCode();
        this.qty = sale.getQty();
        this.unitPrice = sale.getUnitPrice();
        this.amount = sale.getAmount();
        this.paymentType = sale.getPaymentType();
        this.status = sale.getStatus();
        this.date = sale.getDate();
        this.modifiedDate = sale.getModifiedDate();

    }

    private int saleId;

    private Integer userAccountId;

    private int customerId;

    private ProductDto product;

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
		this.qty = customerId;
		this.unitPrice=unitPrice;
		this.amount = amount;
		this.paymentType=paymentType;
		
	}
	public SaleDto(Sale sale) {
		// TODO Auto-generated constructor stub
	}

}