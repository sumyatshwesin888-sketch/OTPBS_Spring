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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("product")
	public List<ProductDto> getProduct(@RequestParam(name="type",defaultValue = "ALL")String productType,
			@RequestParam(name="locationType",defaultValue = "ALL")String locationType,
    		@RequestParam(name="search",defaultValue = "")String search) {
		
		return productService.getProduct(productType,locationType,search);
	}
	
	@GetMapping("product/stats")
    public List<ProductDto> getAboutStats() {
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
//<<<<<<< HEAD
	
	@GetMapping("product/{productId}")
	public ProductDto getProductById(@PathVariable("productId")int productId) {
		
		return productService.getProductById(productId);
	}
//=======
	@PutMapping("product/photo/{productId}/{photoIndex}")
	public int updateProductPhoto(@PathVariable("productId")int productId,@RequestParam(value = "file",required=false) MultipartFile file,
			@PathVariable(name="photoIndex")int photoIndex) {
		try {
			return productService.updateProductPhoto(productId,file,photoIndex);
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Update,Product File Error!", e);
			}
//>>>>>>> 88fa0d793f98df46a2f45473dc9d32297ede24b5
	}
	
}
