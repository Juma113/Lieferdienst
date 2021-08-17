package de.lieferdienst.controllers.productManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.productManagment.Category;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.CategoryRepository;
import de.lieferdienst.repository.storage.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/default")
    ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Product> findCategoryByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.productRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Product found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Product> addNewProduct(@RequestParam String productName,@RequestParam String Description,@RequestParam double price,@RequestParam String imagPath,@RequestParam Long categoryId) {
       Optional <Category> optionalCategory = categoryRepository.findById(categoryId);
       Category category = optionalCategory.get();
        Product product = new Product(productName,Description,price,imagPath,category);
        return ResponseEntity.ok(this.productRepository.save(product));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        return productRepository.findById(id)
                .map( product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setCategory(newProduct.getCategory());
                    return ResponseEntity.ok(this.productRepository.save(product));
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return ResponseEntity.ok(this.productRepository.save(newProduct));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id) {
        this.productRepository.deleteById(id);
    }

}
