package com.hannahhaken.dining_review.repository;

import com.hannahhaken.dining_review.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void can_create_and_retrieve_user() {

        //given
        User expectedUser = new User();
        expectedUser.setUsername("Cloud Strife");
        expectedUser.setCity("Manchester");
        expectedUser.setCountry("England");

        userRepository.save(expectedUser);

        //when
        User newUser = userRepository.findByUsername("Cloud Strife");

        //then

        assertThat("User ID should not be null", newUser.getId(), notNullValue());
        assertEquals(expectedUser.getUsername(), newUser.getUsername());
        assertEquals(expectedUser.getCity(), newUser.getCity());
        assertEquals(expectedUser.getCountry(), newUser.getCountry());
    }
}