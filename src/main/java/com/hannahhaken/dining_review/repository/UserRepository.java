package com.hannahhaken.dining_review.repository;

import com.hannahhaken.dining_review.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}