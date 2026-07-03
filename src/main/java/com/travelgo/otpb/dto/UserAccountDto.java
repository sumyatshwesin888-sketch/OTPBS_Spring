package com.travelgo.otpb.dto;


import com.travelgo.otpb.domain.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class UserAccountDto{

	public UserAccountDto(UserAccount ua) {
		// TODO Auto-generated constructor stub
		//this.userAccountId = ua.getUserAccountId();
		
	}


	private Integer userAccountId;
	private String profileName;

	private String userType;
	private String phone;
	private String email;

	private String password;


	private Integer status;

}
