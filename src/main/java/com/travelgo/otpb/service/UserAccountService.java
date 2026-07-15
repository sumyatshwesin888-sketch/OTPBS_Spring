package com.travelgo.otpb.service;

import java.util.List;
import com.travelgo.otpb.dto.UserAccountDto;

public interface UserAccountService {

    List<UserAccountDto> getUserAccount(String userType, String search);

    int addUserAccount(UserAccountDto dto);

    int updateUserAccount(UserAccountDto dto);

    int deleteUserAccount(int userAccountId);

	UserAccountDto login(String email, String password);

	UserAccountDto getUserHome();
}