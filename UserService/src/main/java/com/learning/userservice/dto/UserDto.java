package com.learning.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String uName;
    private List<OrderDto> order;

}