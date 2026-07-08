package com.travelgo.otpb.controller;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.travelgo.otpb.dto.CityDto;
import com.travelgo.otpb.dto.MessageDto;
import com.travelgo.otpb.util.DateTimeFormatDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class PackageCity {
	List<CityDto> domestic;
	List<CityDto> international;
	
}
