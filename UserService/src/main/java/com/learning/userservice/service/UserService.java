package com.learning.userservice.service;

import com.learning.userservice.exceptions.UserNotFoundException;
import com.learning.userservice.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User getUser(int id,List<User> ul) {
        return ul.stream()
                .filter(u-> (u.getuId() == id))
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("user Not found with id :: "+ id ));
    }

    public User updateUser(final int uId, final User userDetails, final List<User> userList){
        User existingUser = getUser(uId, userList);
        if (userDetails.getuName() != null) {
            existingUser.setuName(userDetails.getuName());
        }
        if (userDetails.getAddress() != null) {
            existingUser.setAddress(userDetails.getAddress());
        }
        if (userDetails.getContact() != null) {
            existingUser.setContact(userDetails.getContact());
        }
        return existingUser;
    }

}