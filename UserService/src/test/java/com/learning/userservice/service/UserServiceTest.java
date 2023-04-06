package com.learning.userservice.service;

import com.learning.userservice.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    private UserService userServiceUnderTest;

    @BeforeEach
    void setUp() {
        userServiceUnderTest = new UserService();
    }

    @Test
    void testGetUser() {
        // Setup
        final List<User> userList = List.of(new User(0, "uName", "address", "contact"));
        final User expectedResult = new User(0, "uName", "address", "contact");

        // Run the test
        final User result = userServiceUnderTest.getUser(0, userList);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateUser() {
        // Setup
        final User userDetails = new User(0, "uName", "address", "contact");
        final List<User> userList = List.of(new User(0, "uName", "address", "contact"));
        final User expectedResult = new User(0, "uName", "address", "contact");

        // Run the test
        final User result = userServiceUnderTest.updateUser(0, userDetails, userList);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getUser() {
    }
}
