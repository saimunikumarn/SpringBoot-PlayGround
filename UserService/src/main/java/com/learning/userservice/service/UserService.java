package com.learning.userservice.service;

import com.learning.userservice.dao.UserDetails;
import com.learning.userservice.models.User;
import com.learning.userservice.exceptions.UserNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    SessionFactory sessionfactory;
    public UserDetails findUser(Integer id) {

    }
    public UserDetails getUser(final int uId, final List<UserDetails> userList){
        Session session = sessionfactory.openSession();
        Transaction tx = session.beginTransaction();
        UserDetails usr = session.load(UserDetails.class, id);
        tx.commit();
        return usr;
        }

    public UserDetails updateUser(final int uId, final UserDetails userDetails, final List<UserDetails> userList){
        UserDetails existingUser = getUser(uId, userList);
        if (userDetails.getUName() != null) {
            existingUser.setUName(userDetails.getUName());
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