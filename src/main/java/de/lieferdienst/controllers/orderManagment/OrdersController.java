package de.lieferdienst.controllers.orderManagment;

import de.lieferdienst.model.errors.NotFounfException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.orderManagment.Orders;
import de.lieferdienst.model.orderManagment.Payment;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.repository.storage.AddressRepository;
import de.lieferdienst.repository.storage.OrdersRepository;
import de.lieferdienst.repository.storage.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Transactional
    @RestController
    @RequestMapping("/api/order")
public class OrdersController {

    private final OrdersRepository ordersRepository;

    private final AddressRepository addressRepository;

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository, AddressRepository addressRepository, ShoppingCartRepository shoppingCartRepository) {
        this.ordersRepository = ordersRepository;
        this.addressRepository = addressRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @GetMapping("/default")
    ResponseEntity<List<Orders>> getAllOrders()
    {
        return ResponseEntity.ok(this.ordersRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Orders> findOrderByID(@PathVariable(value = "id") Long id) throws NotFounfException
    {
        return ResponseEntity.ok(this.ordersRepository
                .findById(id)
                .orElseThrow(() -> new NotFounfException("No Order found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Orders> addNewOrder(@RequestParam Long addressId, @RequestParam Long shoppingCartId) {
        Address address = addressRepository.findById(addressId).get();
        ShoppingCart shoppingcart = shoppingCartRepository.findById(shoppingCartId).get();
        Orders order = new Orders();
        order.setShippingAddress(address);
        order.setShoppingcart(shoppingcart);
        order.setPayment(new Payment());
        return ResponseEntity.ok(this.ordersRepository.save(order));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders newOrder) {
        return ordersRepository.findById(id)
                .map(order -> {
                    order.setOrdered(newOrder.getOrdered());
                    order.setShipped(newOrder.getShipped());
                    order.setShippingAddress(newOrder.getShippingAddress());
                    order.setOrderStatus(newOrder.getOrderStatus());
                    order.setShippingStatus(newOrder.getShippingStatus());
                    order.setShoppingcart(newOrder.getShoppingcart());
                    order.setPayment(newOrder.getPayment());
                    return ResponseEntity.ok(this.ordersRepository.save(order));
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return ResponseEntity.ok(this.ordersRepository.save(newOrder));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteOrder(@PathVariable Long id) {
        this.ordersRepository.deleteById(id);
    }
}
