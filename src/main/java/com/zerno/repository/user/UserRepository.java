package com.zerno.repository.user;

import com.zerno.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    Optional<User> findByEmail(String email);

    // Find user by phone
    Optional<User> findByPhone(String phone);

    // Find user by email or phone (useful for login)
    Optional<User> findByEmailOrPhone(String email, String phone);
}
