package de.lieferdienst.controllers.productManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.productManagment.Restaurant;
import de.lieferdienst.repository.storage.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/default")
    ResponseEntity<List<Restaurant>> getAllRestaurants()
    {
        return ResponseEntity.ok(this.restaurantRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Restaurant> findRestaurantByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.restaurantRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Restaurant found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(this.restaurantRepository.save(restaurant));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant newRestaurant) {
        return restaurantRepository.findById(id)
                .map( restaurant -> {
                    restaurant.setRestaurantName(newRestaurant.getRestaurantName());
                    return ResponseEntity.ok(this.restaurantRepository.save(restaurant));
                })
                .orElseGet(() -> {
                    newRestaurant.setId(id);
                    return ResponseEntity.ok(this.restaurantRepository.save(newRestaurant));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteRestaurant(@PathVariable Long id) {
        this.restaurantRepository.deleteById(id);
    }

}
