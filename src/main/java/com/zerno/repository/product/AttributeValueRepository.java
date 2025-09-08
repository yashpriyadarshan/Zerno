package com.zerno.repository.product;

import com.zerno.entity.product.AttributeValue;
import com.zerno.entity.product.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {

    // Get all values for a given attribute
    List<AttributeValue> findByAttribute(Attribute attribute);

    // Get values by attribute id
    List<AttributeValue> findByAttributeId(Long attributeId);

    // Check if a specific value exists for an attribute
    boolean existsByAttributeAndValue(Attribute attribute, String value);
}
