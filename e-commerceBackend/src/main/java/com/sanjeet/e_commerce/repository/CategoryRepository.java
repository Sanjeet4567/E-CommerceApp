package com.sanjeet.e_commerce.repository;

import com.sanjeet.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByName(String name);
    @Query("Select c from Category c Where c.name=:name And c.parentCategory.name=:parentCategoryName")
    public Category findByNameAndParent(@Param("name")String name,@Param("parentCategoryName")String parentCategoryName);
}
