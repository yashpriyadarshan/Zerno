package com.zerno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phoneNumber")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(unique = true, nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private String password; // Will be hashed using BCrypt

    private String emailValidationToken; // Token for email verification
    private String phoneValidationToken; // Token for phone verification
    private boolean isEmailVerified = false;
    private boolean isPhoneVerified = false;
    private boolean mfaEnabled = false;
    private boolean isActive = true;

    private int failedLoginAttempts; // Track failed login attempts
    private boolean accountLocked; // Account lock status for brute-force protection
    private LocalDateTime lockUntil; // Time when the account will be unlocked


    private String resetToken; // Password reset token
    private LocalDateTime resetTokenExpiry; // Token expiry time

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime lastLoginAt;
}
