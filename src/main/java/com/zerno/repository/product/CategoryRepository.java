package com.zerno.repository.product;

import com.zerno.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Find category by unique slug
    Optional<Category> findBySlug(String slug);

    // Find category by name
    Optional<Category> findByName(String name);

    // Get all child categories of a parent
    List<Category> findByParent(Category parent);

    // Get all child categories by parentId
    List<Category> findByParentId(Long parentId);

    // Check existence by slug
    boolean existsBySlug(String slug);

    // Check existence by name
    boolean existsByName(String name);
}
