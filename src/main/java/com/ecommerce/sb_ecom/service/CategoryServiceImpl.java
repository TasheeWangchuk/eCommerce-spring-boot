package service;

import model.Category;
import repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
//    private List<Category> categories = new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(category);
        return "Category: "+categoryId+"deleted successfully";
    }

    @Override
    public Category updateCategory(Category category,Long categoryId) {
       Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
       Category savedCategory = savedCategoryOptional
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
       category.setCategory_id(categoryId);
       return categoryRepository.save(category);

    }

}
