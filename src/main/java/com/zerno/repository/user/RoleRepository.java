package com.zerno.repository.user;

import com.zerno.entity.user.Role;
import com.zerno.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find role by its enum name
    Optional<Role> findByRoleName(RoleType roleName);
}
