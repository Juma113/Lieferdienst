package de.lieferdienst.model.orderManagmant;

import de.lieferdienst.model.errors.ShoppingCartEmptyException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.orderManagment.*;
import de.lieferdienst.model.productManagment.Category;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.model.productManagment.Restaurant;
import de.lieferdienst.model.userManagment.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;

public class OrderTest {

    Address address1;
    User user1;
    Restaurant restaurant1;
    Category category1;
    Product product1;
    ShoppingCart shoppingcart1;
    Orders order1;

    @BeforeEach
    void setUp() {
        address1 = new Address("streetTest", "5a", "99085", "cityTest");
        user1 = new User("firstNameTest", "LastNameTest", "user@mail.com", "password",
                LocalDate.of(1998, 9, 23), "01716181447",
                address1, shoppingcart1);
        restaurant1 = new Restaurant("Sham");
        category1 = new Category("shamPizza",restaurant1);
        product1 = new Product("Schawrma BOX","mit Pommes und Soße",3.49,"img/food-delivery/restaurants/single/shawarmaBox.png",category1);
        shoppingcart1 = createNotEmptyShoppingCart(product1);
        try {
            order1 = new Orders(address1, shoppingcart1);
        } catch (ShoppingCartEmptyException e) {
            e.printStackTrace();
        }
    }

    private ShoppingCart createNotEmptyShoppingCart(Product product) {
        ShoppingCart shoppingcart = new ShoppingCart();
        shoppingcart.addProduct(product);
        return shoppingcart;
    }

    @Test
    public void TestIfNewOrderWithOrderStatusRegistriertWorks() throws ShoppingCartEmptyException {
        //Given
        OrderStatus registriert = OrderStatus.REGISTRIERT;
        //When
        //Then
        assertEquals(registriert, order1.getOrderStatus());
    }

    @Test
    public void TestIfCalcTotalWithShippingFeeWorks() throws ShoppingCartEmptyException {
        //Given
        //When
        //Then
        assertEquals(7.48, order1.getTotal()); // Price of Product without fee should be 3.49 + SHIPPINGFEE(3.99)
    }

    @Test
    public void TestIfSetShippingStatusWorks() throws ShoppingCartEmptyException {
        //Given
        //When
        order1.setShippingStatus(ShippingStatus.GESENDET);
        //Then
        assertTrue(order1.getShipped() != null);
    }

    @Test
    public void TestIfPaymentMethodWorks() {
        //Given
        order1.setPayment(new Payment(PaymentMethod.PAYPAL, "tests"));
        //When
        //Then
        assertEquals(PaymentMethod.PAYPAL, order1.getPayment().getPaymentMethod());
    }

    @Test
    public void shouldBePaidIfPaymentDateIsSet() {
        //Given
        //When
        order1.getPayment().setDatePaid(new Date());
        //Then
        assertTrue(order1.wasAlreadyPaid());
    }
}
