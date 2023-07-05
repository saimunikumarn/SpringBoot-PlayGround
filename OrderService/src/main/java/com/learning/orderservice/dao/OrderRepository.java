package com.learning.orderservice.dao;

import com.learning.orderservice.models.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, Integer> {

    List<OrderDetails> findOrderDetailsByUid(int uid);
}
