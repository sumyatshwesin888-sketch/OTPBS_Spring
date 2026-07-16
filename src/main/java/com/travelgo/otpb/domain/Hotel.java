package com.travelgo.otpb.domain;

import javax.persistence.*;
import com.travelgo.otpb.dto.HotelDto;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId; 
    private int cityId;
    private String hotelName;
    
    public Hotel() {}
    public Hotel(HotelDto dto) {
        this.hotelId = dto.getHotelId();
        this.hotelName = dto.getHotelName(); 
        this.cityId  = dto.getCityDto().getCityId();
    }
    public Integer getHotelId() { return hotelId; }
    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }

    public Integer getCityId() { return cityId; }
    public void setCityId(Integer cityId) { this.cityId = cityId; }

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
}