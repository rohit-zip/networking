package com.gn128.networking.repository;

import com.gn128.networking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.repository
 * Created_on - November 29 - 2024
 * Created_at - 20:43
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
