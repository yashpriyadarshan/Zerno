package com.zerno.repository.product;

import com.zerno.entity.product.Attribute;
import com.zerno.type.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    // Find by name
    Optional<Attribute> findByName(String name);

    // Check if an attribute with this name already exists
    boolean existsByName(String name);

    // Find attributes by type (STRING, NUMBER, BOOLEAN)
    List<Attribute> findByType(AttributeType type);
}
