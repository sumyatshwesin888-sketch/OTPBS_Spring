package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> getProduct();

	void saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Product product);

	ProductDto getProductDetail(int productId);

	List<ProductDto> getProductByProductId(int productId);

}
