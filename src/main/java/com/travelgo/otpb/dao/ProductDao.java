package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.Product;

public interface ProductDao {

	List<Product> getProduct();

	void saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Product product);

}
