package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.travelgo.otpb.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProduct(String productType, String locationType, String search);

	int addProduct(ProductDto dto);

	int updateProduct(ProductDto dto);

	int deleteProduct(int productId);

	int updateProductPhoto(int productId, MultipartFile file,int photoIndex);

	List<ProductDto> getProduct();

	

}
