package com.gmibank.utilities;

import java.util.Map;

public class User {

    private String ssn;

    private String firstName;

    private String lastName;

    private String address;

    private String mobilePhoneNumber;

    private String username;

    private String email;

    private String password;

    public User(Map<String, String> userInfoMap) {
        this.ssn = userInfoMap.get("ssnNumber");
        this.firstName = userInfoMap.get("firstName");
        this.lastName = userInfoMap.get("lastName");
        this.address = userInfoMap.get("address");
        this.mobilePhoneNumber = userInfoMap.get("mobilePhoneNumber");
        this.username = userInfoMap.get("userName");
        this.email = userInfoMap.get("email");
        this.password = userInfoMap.get("newPassword");
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

