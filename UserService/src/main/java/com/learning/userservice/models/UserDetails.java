package com.learning.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class UserDetails {
    @Id
    private Integer uid;
    private String uname;
    private String address;
    private String contact;

}
