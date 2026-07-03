package com.travelgo.otpb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelgo.otpb.dao.UserAccountDao;
import com.travelgo.otpb.domain.UserAccount;
import com.travelgo.otpb.dto.UserAccountDto;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountDao userAccountDao;

    @Transactional(readOnly = true)
    @Override
    public List<UserAccountDto> getUserAccount() {
        List<UserAccount> userAccountList = userAccountDao.getUserAccount();
        List<UserAccountDto> dtoList = new ArrayList<UserAccountDto>();
        for (UserAccount userAccount : userAccountList) {
            UserAccountDto dto = new UserAccountDto(userAccount);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = false)
    @Override
    public int addUserAccount(UserAccountDto dto) {
        UserAccount userAccount = new UserAccount(dto);
        userAccountDao.saveUserAccount(userAccount);
        return userAccount.getUserAccountId();
    }

    @Transactional(readOnly = false)
    @Override
    public int updateUserAccount(UserAccountDto dto) {
        UserAccount userAccount = new UserAccount(dto);
        userAccountDao.updateUserAccount(userAccount);
        return userAccount.getUserAccountId();
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteUserAccount(int userAccountId) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserAccountId(userAccountId);
        userAccountDao.deleteUserAccount(userAccount);
        return userAccountId;
    }
}