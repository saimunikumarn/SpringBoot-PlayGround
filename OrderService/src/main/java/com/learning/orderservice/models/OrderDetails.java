package com.learning.orderservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderDetails {
    @Id
    private Integer oid;
    private String oname;
    private String address;
    private int uid;
}
