package com.travelgo.otpb.domain;

import javax.persistence.*;

import org.apache.xmlbeans.UserType;

@Entity
@Table(name = "useraccount")
public class UserAccount {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAccountId;

    private String profileName;
    private String phone;
    
//    @Enumerated(EnumType.STRING)
    private String userType;
    
    private String email;
    private String password;
    private int status;//1 is active , 0 is inactive

    public UserAccount() {
        // Default constructor
    }

    
    public UserAccount(com.travelgo.otpb.dto.UserAccountDto dto) {
        this.userAccountId = dto.getUserAccountId();
        this.profileName = dto.getProfileName();
        this.phone = dto.getPhone();
        this.userType = dto.getUserType();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.status = 1;
    }

    // Getters and Setters
    public Integer getUserAccountId() { return userAccountId; }
    public void setUserAccountId(Integer userAccountId) { this.userAccountId = userAccountId; }

    public String getProfileName() { return profileName; }
    public void setProfileName(String profileName) { this.profileName = profileName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}