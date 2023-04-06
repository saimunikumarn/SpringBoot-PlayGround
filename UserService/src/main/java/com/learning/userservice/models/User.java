package com.learning.userservice.models;


import jakarta.persistence.Id;

import java.io.Serializable;


public class User {
    private Integer uId;
    private String uName;
    private String address;
    private String contact;

    public User(Integer uId, String uName, String address, String contact) {
        this.uId = uId;
        this.uName = uName;
        this.address = address;
        this.contact = contact;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
