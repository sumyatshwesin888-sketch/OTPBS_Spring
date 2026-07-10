package com.travelgo.otpb.dao;

import java.util.List;

import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.UserAccountDto;

public interface UserAccountDao {

    List<UserAccount> getUserAccount();

    void saveUserAccount(UserAccount userAccount);

    void updateUserAccount(UserAccount userAccount);

    void deleteUserAccount(UserAccount userAccount);

    UserAccountDto login(String email, String password);

}