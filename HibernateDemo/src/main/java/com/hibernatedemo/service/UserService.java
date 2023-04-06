package com.hibernatedemo.service;

import com.hibernatedemo.dao.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    SessionFactory sessionfactory;

    public String saveUser(UserDetails user) {
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return "User Saved";

    }

    public UserDetails findUser(Integer id) {
        Session session = sessionfactory.openSession();
        Transaction tx = session.beginTransaction();
        UserDetails usr = session.load(UserDetails.class, id);
        tx.commit();
        return usr;
    }

}