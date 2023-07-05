package com.learning.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductDetails {
    @Id
    private int pid;
    private String pname;
    private int oid;
}
