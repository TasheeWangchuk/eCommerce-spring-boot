package com.ecommerce.sb_ecom.repository;

import com.ecommerce.sb_ecom.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name should atleast contain 5 character") String categoryName);
}
