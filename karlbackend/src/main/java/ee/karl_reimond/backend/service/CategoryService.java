package ee.karl_reimond.backend.service;

import ee.karl_reimond.backend.model.Category;
import ee.karl_reimond.backend.repostiroy.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;



    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    // save
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    // delete
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    // get one by id
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }
}