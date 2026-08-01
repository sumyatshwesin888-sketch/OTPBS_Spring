package com.travelgo.otpb.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> getProduct(String productType, String locationType, String search,String status);
	List<ProductDto> getProduct();

	void saveProduct(Product product);

	void updateProduct(Product product);

	ProductDto getProductDetail(int productId);

	ProductDto getProductById(int productId);

	List<ProductDto> getProductByProductId(int productId);
	int updateProductPhoto(int productId, MultipartFile file,int photoIndex);

	Integer getTotalProductsCount();
	void updateTicket(int productId, int qty);
	boolean deleteProduct(int productId);

}
