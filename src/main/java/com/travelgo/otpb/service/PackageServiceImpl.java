package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.controller.PackageCity;
import com.travelgo.otpb.dao.CommentDao;
import com.travelgo.otpb.dao.ItineraryDao;
import com.travelgo.otpb.dao.PackageDao;
import com.travelgo.otpb.dao.ProductDao;
import com.travelgo.otpb.dao.RatingDao;
import com.travelgo.otpb.domain.Comment;
import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.domain.Rating;
import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.CityTypeDto;
import com.travelgo.otpb.dto.ItineraryDto;
import com.travelgo.otpb.dto.ProductDetail;
import com.travelgo.otpb.dto.ProductDto;
import com.travelgo.otpb.dto.RatingDto;
import com.travelgo.otpb.dto.UserAccountDto;


@Service
public class PackageServiceImpl  implements PackageService {
	@Autowired
	PackageDao packDao;
	@Autowired
	RatingDao ratingDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	ProductDao proDao;
	@Autowired
	ItineraryDao itDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getPackage() {
		// TODO Auto-generated method stub
		
		return packDao.getPackage();
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageByLocationType(String locationType) {
		// TODO Auto-generated method stub
		return packDao.getPackageByLocationType(locationType);
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageDetail(int packageId) {
		// TODO Auto-generated method stub
		return packDao.getPackageDetail(packageId);
	}

//	@Override
//	public int addPackage(ProductDto dto) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Transactional(readOnly=false)
//	@Override
//	public int addPackage(ProductDto dto) {
//	    try {
//	        Product product = new Product(dto);
//	        return productDao.saveProduct(product);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return 0;
//	}
	
//	@Transactional(readOnly=false)
//	@Override
//	public int addPackage(ProductDto dto) { 
//	    Product product = new Product(dto); 
//	    proDao.saveProduct(product);
//	    return product.getProductId(); 
//	}

	@Override
	public int updatePackage(ProductDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePackage(int packageId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly=true)
	@Override
	public PackageCity getPackageByCity() {
		// TODO Auto-generated method stub
		
		return packDao.getPackageByCity();
	}

	@Transactional(readOnly=false)
	@Override
	public int saveRatingComment(RatingDto dto) {
		// TODO Auto-generated method stub
		Rating ra = new Rating();
		ra.setRating(dto.getRating());
		ra.setCustomerId(dto.getUserAccountDto().getUserAccountId());
		ra.setProductId(dto.getProductId());
		ra.setDate(new Date());
		ratingDao.saveRating(ra);
		
		Comment c = new Comment();
		c.setDate(new Date());
		c.setMessage(dto.getComment());
		c.setProductId(dto.getProductId());
		c.setCustomerId(dto.getUserAccountDto().getUserAccountId());
		commentDao.saveComment(c);
		
		
		return 1;
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityTypeDto> getPackageByLocationTypeCommCount(String locationType, int commentCount) {
		// TODO Auto-generated method stub
		return packDao.getPackageByLocationType(locationType,commentCount);
	}

	@Transactional(readOnly=true)
	@Override
	public ProductDetail getPackageDetailById(int productId) {
		// TODO Auto-generated method stub
		ProductDto prodto = proDao.getProductDetail(productId);
		List<ItineraryDto> itList = itDao.getItineraryByProductId(productId);
		List<RatingDto> ratingList = ratingDao.getRatingCommentByProductId(productId);
		
		ProductDetail detail = new ProductDetail();
		detail.setProductDto(prodto);
		detail.setItineraryList(itList);
		detail.setRatingCommentList(ratingList);
		return detail;
	}

	@Override
	public int addPackage(ProductDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional(readOnly=true)
	  @Override
	  public List<CityTypeDto> getPackageByCityId(int cityId) {

	      return packDao.getPackageByCityId(cityId);

	  }

	

	

}
