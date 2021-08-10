package de.lieferdienst.controllers.orderManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.repository.storage.ProductRepository;
import de.lieferdienst.repository.storage.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/cart/default")
    ResponseEntity<List<ShoppingCart>> getAllShoppingCarts()
    {
        return ResponseEntity.ok(this.shoppingCartRepository.findAll());
    }

    @GetMapping(path = "/cart/{id}")
    ResponseEntity<ShoppingCart> findShoppingCatByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.shoppingCartRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No ShoppingCart found for id " + id)));
    }

    @PostMapping(path = "/cart/add", produces = "application/json")
    ResponseEntity<ShoppingCart> addNewShoppingCart(@RequestBody ShoppingCart shoppingCart)
    {
        return ResponseEntity.ok(this.shoppingCartRepository.save(shoppingCart));
    }

    @PutMapping(path = "/cart/update/{id}", produces = "application/json")
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

    @DeleteMapping("/cart/delete/{id}")
    void deleteShoppingCart(@PathVariable Long id) {
        this.shoppingCartRepository.deleteById(id);
    }

    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/cart/add/{id}/addProduct/{productId}")
    ShoppingCart addProductToShoppingCart(@PathVariable Long id,@PathVariable Long productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        shoppingCart.get().addProduct(product.get());
        return shoppingCartRepository.save(shoppingCart.get());
    }

    @PostMapping(path = "/cart/delete/{id}/deleteProduct/{productId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    ShoppingCart deleteProductFromShoppingCart(@PathVariable Long id,@PathVariable Long productId)
    {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        shoppingCart.get().deleteProduct(product.get());
        return shoppingCartRepository.save(shoppingCart.get());
    }

}
