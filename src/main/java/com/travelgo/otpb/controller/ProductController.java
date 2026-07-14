package com.travelgo.otpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("product")
	public List<ProductDto> getProduct() {
		
		return productService.getProduct();
	}
	
	@PostMapping("product")
	public int addProduct(@RequestBody ProductDto dto) {
		
		return productService.addProduct(dto);
	}
	@PutMapping("product/{productId}")
	public int updateProduct(
			@PathVariable("productId")int productId,
			@RequestBody ProductDto dto) {
		dto.setProductId(productId);
		return productService.updateProduct(dto);
	}
	@DeleteMapping("product/{productId}")
	public int deleteProduct(
			@PathVariable("productId")int productId) {
		return productService.deleteProduct(productId);
	}
//	
//	@GetMapping("product/{productId}")
//	public List<ProductDto> getProduct(
//			@PathVariable("productId")int productId) {
//		return productService.getProduct();
//	}
	
}
