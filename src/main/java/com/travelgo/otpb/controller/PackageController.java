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

import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ProductDetail;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.RatingDto;
import com.travelgo.otpb.service.PackageService;
import com.travelgo.otpb.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class PackageController {
	@Autowired
	PackageService packageService;
	
	@GetMapping("package")
	public List<ProductDto> getPackage() {
		try {
			return packageService.getPackage();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("package/type")
	public List<CityTypeDto> getPackageByLocationType(@RequestParam(name="locationType",defaultValue = "DOMESTIC")String locationType) {//locationType is 
		try {
			return packageService.getPackageByLocationType(locationType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("package")
	public int addPackage(@RequestBody ProductDto dto) {
		return packageService.addPackage(dto);
	}
	@PutMapping("package/{packageId}")
	public int updatePackage(
			@PathVariable("package")int packageId,
			@RequestBody ProductDto dto) {
		dto.setPackageId(packageId);
		return packageService.updatePackage(dto);
	}
	@DeleteMapping("package/{packageId}")
	public int deletePackage(
			@PathVariable("packageId")int packageId) {
		return packageService.deletePackage(packageId);
	}
	
	
//	for PackageDetail page
//	@GetMapping("packagedetail/{packageId}")
//	public List<CityTypeDto> getPackageDetail(@PathVariable("packageId")int packageId ) { 
//		try {
//			return packageService.getPackageDetail(packageId);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@GetMapping("package/city")
	public PackageCity getPackageByCity() {
		return packageService.getPackageByCity();
	}
	
	//package detail page
	@PostMapping("package/ratingcomment")
	public int saveRatingComment(@RequestBody RatingDto dto) {
		 System.out.println("========== RATING API CALLED ==========");
		    System.out.println(dto);
		
			return packageService.saveRatingComment(dto);
		
	}
	
	//packages page 
	@GetMapping("package/type/commentcount")
	public List<CityTypeDto> getPackageByLocationTypeCommCount(@RequestParam(name="locationType",defaultValue = "DOMESTIC")String locationType,
			@RequestParam(name="commentCount",defaultValue = "0")int commentCount) {//locationType is 
		try {
			return packageService.getPackageByLocationTypeCommCount(locationType,commentCount);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("package/detail/{productId}")
	public ProductDetail getPackageDetailById(@PathVariable("productId")int productId ) { 
		try {
			return  packageService.getPackageDetailById(productId);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/package/city/{cityId}")
	  public List<CityTypeDto> getPackageByCityId(@PathVariable("cityId") int cityId){

	      try {

	          return packageService.getPackageByCityId(cityId);

	      } catch (Exception e) {

	          e.printStackTrace();

	      }

	      return null;

	  }

}
