package com.travelgo.otpb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.travelgo.otpb.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProduct(String productType, String locationType, String search);

	int addProduct(ProductDto dto);

	int updateProduct(ProductDto dto);

	int deleteProduct(int productId);

//<<<<<<< HEAD
	ProductDto getProductById(int productId);
//=======
	int updateProductPhoto(int productId, MultipartFile file,int photoIndex);
//>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5

	List<ProductDto> getProduct();

	

}
