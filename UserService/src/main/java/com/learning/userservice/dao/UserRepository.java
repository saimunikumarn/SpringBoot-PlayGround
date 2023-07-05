package com.learning.userservice.dao;

import com.learning.userservice.models.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer> {
}
