package ee.karl_reimond.backend.controller;

import ee.karl_reimond.backend.model.Category;
import ee.karl_reimond.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("categories")
    public String saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);

        return "saved: " + category.getName();
    }

    @GetMapping("categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        String name = categoryService.getCategoryById(id).getName();
        categoryService.deleteCategory(categoryService.getCategoryById(id));
        return "deleted: " + name;
    }
}