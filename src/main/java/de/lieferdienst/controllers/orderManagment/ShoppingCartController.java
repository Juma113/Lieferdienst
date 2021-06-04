package de.lieferdienst.controllers.orderManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.ProductRepository;
import de.lieferdienst.repository.storage.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/default")
    ResponseEntity<List<ShoppingCart>> getAllShoppingCarts()
    {
        return ResponseEntity.ok(this.shoppingCartRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<ShoppingCart> findShoppingCatByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.shoppingCartRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No ShoppingCart found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<ShoppingCart> addNewShoppingCart(@RequestBody ShoppingCart shoppingCart)
    {
        return ResponseEntity.ok(this.shoppingCartRepository.save(shoppingCart));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable Long id,@RequestBody ShoppingCart newShoppingCart) {
        return shoppingCartRepository.findById(id)
                .map(shoppingCart -> {
                    shoppingCart.setItems(newShoppingCart.getItems());
                    shoppingCart.calcTotalPrice();
                    return ResponseEntity.ok(this.shoppingCartRepository.save(shoppingCart));
                })
                .orElseGet(() -> {
                    newShoppingCart.setId(id);
                    return ResponseEntity.ok(this.shoppingCartRepository.save(newShoppingCart));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteShoppingCart(@PathVariable Long id) {
        this.shoppingCartRepository.deleteById(id);
    }

    @PostMapping(path = "/add/{id}/addProduct/{productId}", produces = "application/json")
    ResponseEntity<ShoppingCart> addProductToShoppingCart(@PathVariable Long id,@PathVariable Long productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        shoppingCart.get().addProduct(product.get());
        return ResponseEntity.ok(this.shoppingCartRepository.save(shoppingCart.get()));
    }

    @PostMapping(path = "/delete/{id}/deleteProduct/{productId}", produces = "application/json")
    ResponseEntity<ShoppingCart> deleteProductFromShoppingCart(@PathVariable Long id,@PathVariable Long productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        shoppingCart.get().deleteProduct(product.get());
        return ResponseEntity.ok(this.shoppingCartRepository.save(shoppingCart.get()));
    }

}
