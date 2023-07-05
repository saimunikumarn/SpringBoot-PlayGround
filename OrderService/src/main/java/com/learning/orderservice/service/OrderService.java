package com.learning.orderservice.service;

import com.learning.orderservice.dao.OrderRepository;
import com.learning.orderservice.dto.OrderDto;
import com.learning.orderservice.dto.ProductDto;
import com.learning.orderservice.exceptions.OrderNotFoundException;
import com.learning.orderservice.models.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Value("${product-service.address}")
    private String productServiceDomain;

    @Autowired
    OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public OrderDetails getOrder(int id) {
        return orderRepository.findById(id).orElse(null);
    }
    public List<OrderDetails> getOrderByUid(int uid) {
        return orderRepository.findOrderDetailsByUid(uid);
    }

    public OrderDetails updateOrder(final int uId, final OrderDetails orderDetails) {
        if (getOrder(uId) != null) {
            orderRepository.save(orderDetails);
        }
        return getOrder(uId);
    }

    public OrderDetails saveOrder(OrderDetails orderDetails) {
        return orderRepository.save(orderDetails);
    }

    public void deleteOrder(int oId) {
        OrderDetails existingOrderDetails = orderRepository.findById(oId).orElseThrow(() -> new OrderNotFoundException("No data available with given Id :" + oId));
        orderRepository.deleteById(existingOrderDetails.getOid());
    }

    public List<OrderDetails> getAllOrders(){
        return (List<OrderDetails>) orderRepository.findAll();
    }

    public String getProductServiceHealth() {
        return restTemplate.getForObject("http://localhost:8082/productHealth", String.class);
    }

    public OrderDto getProductsWithOrderId(int oId) {
        OrderDetails existing = getOrder(oId);
        List<ProductDto> product = restTemplate.getForObject(productServiceDomain + "/findProductByOId/" + oId, List.class);
        OrderDto order = new OrderDto();
        order.setOName(existing.getOname());
        order.setOrder(product);
        return order;
    }
}