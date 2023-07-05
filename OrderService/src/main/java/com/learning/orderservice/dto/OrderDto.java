package com.learning.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String oName;
    private List<ProductDto> order;
}