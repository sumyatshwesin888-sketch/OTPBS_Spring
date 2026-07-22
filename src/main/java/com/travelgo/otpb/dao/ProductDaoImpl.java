package com.travelgo.otpb.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.travelgo.otpb.util.ConvertDate;
import com.travelgo.otpb.domain.City;
import com.travelgo.otpb.domain.Product;
import com.travelgo.otpb.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<ProductDto> getProduct(String productType, String locationType, String search) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sqlWhere = " Where 1=1 ";
		if(!"ALL".equals(productType)) {
			sqlWhere += " AND p.type= '"+productType+"'";
		}
		if(!"ALL".equals(locationType)) {
			sqlWhere += " AND c.locationType= '"+locationType+"'";
				}
		if(!"".equals(search)) {
			sqlWhere += " AND p.title like '%"+search+"%'"; 
		}
		List<Object[]> objList =  session.createNativeQuery(" SELECT p.title,p.type,c.locationType,p.location,p.day,p.night,p.groupSize,"
				+ "p.meals,p.travelDate,p.ticket,p.transport,p.amount,\r\n"
				+ "p.photo,p.photoone,p.photoTwo,p.photoThree,p.photoFour,p.productId\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId "+sqlWhere).getResultList();
		List<ProductDto> dtoList = new ArrayList<ProductDto>();
		for(Object[] obj:objList) {
			String title = (String)obj[0];
			String type = (String)obj[1];
			locationType = (String)obj[2];
			String location = (String)obj[3];
			
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			String groupSize = (String)obj[6];
			String meals = (String)obj[7];
			Date travelDate = (Date)obj[8];
			int ticket = Integer.parseInt(obj[9].toString());
			String transport = (String)obj[10];
			int amount = Integer.parseInt(obj[11].toString());
			String photo = (String)obj[12];
			String photoOne = (String)obj[13];
			String photoTwo = (String)obj[14];
			String photoThree = (String)obj[15];
			String photoFour = (String)obj[16];
			int productId = Integer.parseInt(obj[17].toString());
			int photoCount = 0;
			if(photoOne!=null) {
				photoCount+=1;
			}
			if(photoTwo!=null) {
				photoCount+=1;
			}
			if(photoThree!=null) {
				photoCount+=1;
			}
			if(photoFour!=null) {
				photoCount+=1;
			}
			ProductDto dto = new ProductDto(title,type,locationType,location,
					day,night,groupSize,meals,travelDate,ticket,transport,amount,photo,photoOne,
					photoTwo,photoThree,photoFour);
			dto.setPhotoCount(photoCount);
			dto.setProductId(productId);
			dtoList.add(dto);
		}
		return dtoList;
	}


	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}
	
	
//	for product detail Page for real
	@Override
	public ProductDto getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT p.productId,p.title, p.location, p.amount, p.`day`, p.night, p.travelDate, p.ticket, p.groupSize, p.meals,\r\n"
				+ "AVG(r.rating) AS ratingCount, (cm.commentId) AS commentCount, p.photoone, p.photoTwo, p.photoThree,\r\n"
				+ "p.photoFour,\r\n"
				+ "h.hotelId, h.hotelName, p.detail, p.transport,\r\n"
				+ "COUNT(distinct s.saleId ) AS saleCount,p.photo,c.locationType\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN rating r ON r.productId = p.productId\r\n"
				+ "LEFT JOIN comment cm ON cm.productId = p.productId\r\n"
				+ "LEFT JOIN hotel h ON h.hotelId = p.hotelId\r\n"
				+ "LEFT JOIN sale s ON s.productId = p.productId\r\n"
				+ "LEFT JOIN city c ON c.cityId = h.cityId\r\n"
				+ "WHERE p.productId = :productId\r\n"
				+ "GROUP BY p.productId").setParameter("productId", productId).getResultList();
		
		ProductDto dto = new ProductDto();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			productId = Integer.parseInt(obj[0].toString());
			String title = (String)obj[1];
			String location = (String)obj[2];
			int amount = Integer.parseInt(obj[3].toString());
			int day = Integer.parseInt(obj[4].toString());
			int night = Integer.parseInt(obj[5].toString());
			Date travelDate  = (Date)obj[6];
			int ticket = Integer.parseInt(obj[7].toString());
			String groupSize = (String)obj[8];
			String meals = (String)obj[9];
	
			double ratingCount = obj[10] != null ? Double.parseDouble(obj[10].toString()) : 0.0;
			
			int commentCount = obj[11] != null ? Integer.parseInt(obj[11].toString()) : 0;
			
			String photoOne = (String)obj[12];
			String photoTwo = (String)obj[13];
			String photoThree = (String)obj[14];
			String photoFour = (String)obj[15];
			int hotelId = obj[16] != null ? Integer.parseInt(obj[16].toString()) : 0;
			String hotelName = (String)obj[17];
			String detail = (String)obj[18];
			String transport = (String)obj[19];
			int saleCount = Integer.parseInt(obj[20].toString());
			int leftTicket = ticket - saleCount;
			String photo = (String)obj[21];
			String locationType = (String)obj[22];
			
			dto = new ProductDto(productId,title,location,amount,day,night,travelDate,
					ticket,groupSize,meals,ratingCount,commentCount,photoOne,photoTwo,
					photoThree,photoFour,hotelId, hotelName,detail,transport,saleCount,leftTicket,photo,locationType);
		}
		return dto;
	}
		
//  for About Page
	@Override
	public List<ProductDto> getProduct() {
	    Session session = sessionFactory.getCurrentSession();
	    	    List<Object[]> objList = session.createNativeQuery(
	            "SELECT " +
	            " (SELECT COUNT(DISTINCT useraccountId) FROM sale) AS traveler, " +  
	            " (SELECT COUNT(productId) FROM product) AS packages, " +           
	            " (SELECT COUNT(cityId) FROM city) AS cities"                       
	    ).getResultList();

	    List<ProductDto> dtoList = new ArrayList<ProductDto>();
	    if (objList != null && !objList.isEmpty()) {
	        Object[] row = objList.get(0);
	        int traveler = ((Number) row[0]).intValue();
	        int packages = ((Number) row[1]).intValue();
	        int cities   = ((Number) row[2]).intValue();
	        
	        ProductDto dto = new ProductDto(traveler, packages, cities);
	        dtoList.add(dto);
	    }
	    return dtoList;
	}  
	    
	@Override
	public ProductDto getProductById(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product p =  session.find(Product.class, productId);
		ProductDto dto = new ProductDto(p);
		return dto;
	}


	   

	@Override
	public List<ProductDto> getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updateProductPhoto(int productId, MultipartFile file,int photoIndex) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product p= session.find(Product.class, productId);
		String pwd=new File("").getAbsolutePath();
		if(p.getPhoto()!=null) {
			File deleteFile=new File(pwd+"/productphoto/"+p.getPhoto());//+".png"
			deleteFile.delete();
		}
		String photoCode= ConvertDate.createVoucherCode(new Date());
		if(photoIndex==0) {
			p.setPhoto(photoCode+".png");
		}else if(photoIndex==1) {
			p.setPhotoOne(photoCode+".png");
		}else if(photoIndex==2) {
			p.setPhotoTwo(photoCode+".png");
		}else if(photoIndex==3) {
			p.setPhotoThree(photoCode+".png");
		}else{
			p.setPhotoFour(photoCode+".png");
		}
		//p.setPhoto(photoCode+".png");
		File dir=new File(pwd+"/productphoto/");
		String outPath=pwd+"/productphoto/"+photoCode+".png";
		File dest=new File(outPath);
		try {
			if (!dir.exists()) {
				dir.mkdir();
			}
			file.transferTo(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;

	}


	@Override
	public Integer getTotalProductsCount() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<ProductDto> getProductByProductId(int productId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
