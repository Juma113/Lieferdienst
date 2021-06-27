package de.lieferdienst.controllers.productManagment;


import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.productManagment.Category;
import de.lieferdienst.model.productManagment.Restaurant;
import de.lieferdienst.repository.storage.CategoryRepository;
import de.lieferdienst.repository.storage.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, RestaurantRepository restaurantRepository) {
        this.categoryRepository = categoryRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/default")
    ResponseEntity<List<Category>> getAllCategories()
    {
        return ResponseEntity.ok(this.categoryRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Category> findCategoryByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.categoryRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Category found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Category> addNewCategory(@RequestParam String sortTitle,@RequestParam Long restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        Category category = new Category(sortTitle,restaurant);
        return ResponseEntity.ok(this.categoryRepository.save(category));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        return categoryRepository.findById(id)
                .map( category -> {
                    category.setSortTitle(newCategory.getSortTitle());
                    category.setRestaurant(newCategory.getRestaurant());
                    return ResponseEntity.ok(this.categoryRepository.save(category));
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return ResponseEntity.ok(this.categoryRepository.save(newCategory));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable Long id) {
        this.categoryRepository.deleteById(id);
    }
}
