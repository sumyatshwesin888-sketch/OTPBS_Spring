package com.travelgo.otpb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travelgo.otpb.dto.CityDto;

@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityId;
	private String cityName;
	private String locationType;
	private String photo;
	private String region;
	private String website;
	private String detail;


	public City(CityDto dto) {
		// TODO Auto-generated constructor stub
		this.cityId = dto.getCityId();
		this.cityName = dto.getCityName();
	}

	public City() {
		// TODO Auto-generated constructor stub
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	}
