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


@JsonInclude(value = Include.USE_DEFAULTS)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

//<<<<<<< HEAD
    //public SaleDto(int saleId, int userAccountId, int customerId,  String voucherCode, int qty, int unitPrice, int amount, String paymentType ,Sale sale) {
//=======
//	public SaleDto(Sale sale) {
////>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5
//
//        this.saleId = sale.getSaleId();
//        this.userAccountId = sale.getUserAccountId();
//        this.customerId = sale.getCustomerId();
////<<<<<<< HEAD
////        this.product = new ProductDto(sale.getProductId());
////=======
//
//       // this.product = sale.getProduct();
//       // this.product = new ProductDto(sale.getProductId());
//        this.productId= sale.getProductId();
////>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5
//        this.voucherCode = sale.getVoucherCode();
//        this.qty = sale.getQty();
//        this.unitPrice = sale.getUnitPrice();
//        this.amount = sale.getAmount();
//        this.paymentType = sale.getPaymentType();
//        this.status = sale.getStatus();
//        this.date = sale.getDate();
//        this.modifiedDate = sale.getModifiedDate();
//
//    }

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
    
    private ProductDto product;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
    private Date date;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
    private Date modifiedDate;
//<<<<<<< HEAD
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
	}
//=======
	public SaleDto(int saleId, int userAccountId, int customerId, int productId, String voucherCode, int qty, int unitPrice, int amount,
			String paymentType, String status) {

        this.saleId = saleId;
        this.userAccountId = userAccountId;
        this.customerId = customerId;

       // this.product = sale.getProduct();
       // this.product = new ProductDto(sale.getProductId());
        this.productId= productId;
        this.voucherCode = voucherCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.paymentType = paymentType;
        this.status = status;
        this.date = date;
        this.modifiedDate = modifiedDate;

	}
	public SaleDto(int saleId2, int customerId2, String profileName, int productId2, String title, int qty2,
			int unitPrice2, int amount2, String paymentType2, String status2, Date date2, Date modifiedDate2,
			String voucherCode2) {
		// TODO Auto-generated constructor stub
		this.saleId = saleId2;
		this.customer = new UserAccountDto(customerId2,profileName);
		this.product = new ProductDto(productId2,title);
		this.qty = qty2;
		this.unitPrice = unitPrice2;
		this.amount = amount2;
		this.paymentType = paymentType2;
		this.status = status2;
		this.date = date2;
		this.modifiedDate = modifiedDate2;
		this.voucherCode = voucherCode2;
	}
	
//>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5

}