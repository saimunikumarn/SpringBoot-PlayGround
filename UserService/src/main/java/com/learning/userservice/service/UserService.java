package com.learning.userservice.service;

import com.learning.userservice.dao.UserRepository;
import com.learning.userservice.dto.OrderDto;
import com.learning.userservice.dto.UserDto;
import com.learning.userservice.exceptions.UserNotFoundException;
import com.learning.userservice.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Value("${order-service.address}")
    private String orderServiceDomain;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    UserService(UserRepository userRepository, RestTemplate restTemplate){
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public UserDetails getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDetails updateUser(final int uId, final UserDetails userDetails){
        if(getUser(uId) != null) {
            userRepository.save(userDetails);
        }
        return getUser(uId);
    }

    public UserDetails saveUser(UserDetails userDetails){
        return userRepository.save(userDetails);
    }

    public void deleteUser(int uId){
        UserDetails existingUserDetails = userRepository.findById(uId)
                .orElseThrow(() -> new UserNotFoundException("No data available with given Id :" + uId));
        userRepository.deleteById(existingUserDetails.getUid());
    }

    public String getOrderHealth(){
        return restTemplate.getForObject(orderServiceDomain + "/orderHealth", String.class);
    }

    public UserDto getOrderWithUserId(Integer uId){
        UserDetails existing = getUser(uId);
        List<OrderDto> orders = restTemplate.getForObject(orderServiceDomain + "/findOrderByUid/" +existing.getUid(), List.class);
        UserDto user = new UserDto();
        user.setUName(existing.getUname());
        user.setOrder(orders);
        return user;
    }
}