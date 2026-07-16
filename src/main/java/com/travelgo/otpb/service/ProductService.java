package com.travelgo.otpb.service;

import java.util.List;

import com.travelgo.otpb.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProduct();

	int addProduct(ProductDto dto);

	int updateProduct(ProductDto dto);

	int deleteProduct(int productId);

	ProductDto getProductById(int productId);

	

}
