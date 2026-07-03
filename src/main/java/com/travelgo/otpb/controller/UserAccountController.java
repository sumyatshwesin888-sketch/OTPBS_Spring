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
import org.springframework.web.bind.annotation.RestController;

import com.travelgo.otpb.dto.UserAccountDto;
import com.travelgo.otpb.service.UserAccountService;

@RestController
@RequestMapping("/api/v1/")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("userAccount")
    public List<UserAccountDto> getUserAccount() {
        return userAccountService.getUserAccount();
    }

    @PostMapping("userAccount")
    public int addUserAccount(@RequestBody UserAccountDto dto) {
        return userAccountService.addUserAccount(dto);
    }

    @PutMapping("userAccount/{userAccountId}")
    public int updateUserAccount(
            @PathVariable("userAccountId") int userAccountId,
            @RequestBody UserAccountDto dto) {
        dto.setUserAccountId(userAccountId);
        return userAccountService.updateUserAccount(dto);
    }

    @DeleteMapping("userAccount/{userAccountId}")
    public int deleteUserAccount(
            @PathVariable("userAccountId") int userAccountId) {
        return userAccountService.deleteUserAccount(userAccountId);
    }
}