package com.digitaldark.ChambeaPe_Api.user_security.repository;

import com.digitaldark.ChambeaPe_Api.user_security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface for user repository
 * @version 1.0
 * @Author Ray Del Carmen
 */

public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by its username or email
     * @param email Email
     * @param username Username
     * @return User found (if exists)
     */
    Optional<User> findByEmailOrUsername(String email, String username);

    /**
     * Verify if a user exists by its email
     * @param email Email
     * @return True if exists, false if not
     */
    boolean existsByEmail(String email);

    /**
     * Verify if a user exists by its username
     * @param username Username
     * @return True if exists, false if not
     */
    boolean existsByUsername(String username);
}
