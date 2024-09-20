package com.hannahhaken.dining_review.repository;

import com.hannahhaken.dining_review.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Test
    public void should_throw_exception_when_saving_duplicate_username() {
        String duplicateUsername = "Cloud Strife";
        User firstUser = createUser(duplicateUsername);
        userRepository.save(firstUser);
        entityManager.flush();

        User duplicateUser = createUser(duplicateUsername);

        userRepository.save(duplicateUser);

        assertThatThrownBy(() -> entityManager.flush())
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("could not execute statement");
    }

    private User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}