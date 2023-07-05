package com.learning.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int pId;
    private String pName;
    private int oId;
}