package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.ProductDao;
import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getProduct(String productType, String locationType, String search) {
		// TODO Auto-generated method stub
//		List<Product> productList = productDao.getProduct();
//		List<ProductDto> dtoList = new ArrayList<ProductDto>();
//		for(Product product:productList) {
//			ProductDto dto = new ProductDto(product);
//			dtoList.add(dto);
//		}
		return productDao.getProduct(productType,locationType,search);
	}

	@Transactional(readOnly=false)
	@Override
	public int addProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product product = new Product(dto);
		productDao.saveProduct(product);
		return product.getProductId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product product = new Product(dto);
		productDao.updateProduct(product);
		return product.getProductId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProductId(productId);
		productDao.deleteProduct(product);
		return productId;
	}

}
