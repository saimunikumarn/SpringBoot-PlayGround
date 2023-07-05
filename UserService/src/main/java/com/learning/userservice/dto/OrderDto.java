package com.learning.userservice.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Integer oId;
    private String oName;
    private String address;
    private String uId;
}