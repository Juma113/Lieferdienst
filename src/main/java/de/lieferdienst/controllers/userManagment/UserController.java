package de.lieferdienst.controllers.userManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.userManagment.User;
import de.lieferdienst.repository.storage.AddressRepository;
import de.lieferdienst.repository.storage.ShoppingCartRepository;
import de.lieferdienst.repository.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, AddressRepository addressRepository, ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping("/default")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<User> findById(@PathVariable(value = "id") Long id) throws NotFounfException {
        return ResponseEntity.ok(this.userRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Persons found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<User> saveUser(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddress(addressRepository.save(user.getAddress()));
        user.setShoppingCart(shoppingCartRepository.save(new ShoppingCart()));
        return ResponseEntity.ok(this.userRepository.save(user));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setAddress(newUser.getAddress());
                    user.setDob(newUser.getDob());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(User.get_SHA_256_SecurePassword(newUser.getPassword()));
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setPhone(newUser.getPhone());
                    return ResponseEntity.ok(this.userRepository.save(user));
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return ResponseEntity.ok(this.userRepository.save(newUser));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }
}
