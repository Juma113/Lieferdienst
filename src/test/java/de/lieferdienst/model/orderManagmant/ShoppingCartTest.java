package de.lieferdienst.model.orderManagmant;


import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.productManagment.Category;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.model.productManagment.Restaurant;
import de.lieferdienst.model.userManagment.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;

public class ShoppingCartTest {

    private Address address1;
    private User user1;
    private Restaurant restaurant1;
    private Category category1;
    private Product product1;
    private Product product2;
    private ShoppingCart shoppingCart1;

    @BeforeEach
    void setUp(){
        address1 = new Address("Marcel-Breuer-Ring","5","99085","Erfurt");
        shoppingCart1 = new ShoppingCart();
        user1 = new User("FirstNameTest","LastNameTest",
                "usertest@mail.com","testpassword123",
                LocalDate.of(1997,9,14),"015775651221", address1,shoppingCart1);
        restaurant1 = new Restaurant("Sham");
        category1 = new Category("Arabische Spezialisten",restaurant1);
        product1 = new Product("Teigrolle Fahita","Hähnchenbrust,Paprika",4.00,"img/food-delivery/restaurants/single/fahitaRolle.png",category1);
        product2 = new Product("Mix Teller","2x Hackspieß + 1x Lammspieß+ 1x Shishtauok mit gegrillten Tomaten, Spizpaprika & Zwiebel, Reis und Humus",9.99,"img/food-delivery/restaurants/single/foto.jpg",category1);
        shoppingCart1 = new ShoppingCart();
    }

    @Test
    public void TestIfTotalPriceForNewShoppingCartZero() {
        //Given
        // When
        //Then
        assertEquals(0.0, shoppingCart1.getTotalPrice());
    }

    @Test
    public void TestIfAddProductToShoppingCartWorks() {
        //Given
        // When
        shoppingCart1.addProduct(product1);
        //Then
        List<Product> list = shoppingCart1.getItems();
        boolean foundProduct = list.contains(product1);
        assertTrue(foundProduct);
    }

    @Test
    public void TestIfDeleteProductFromShoppingCartWorks() {
        //Given
        shoppingCart1.addProduct(product1);
        // When
        shoppingCart1.deleteProduct(product1);
        //Then
        List<Product> list = shoppingCart1.getItems();
        boolean foundProduct = false;
        if (!list.isEmpty())
        {
            foundProduct = list.contains(product1);
        }
        assertFalse(foundProduct);
    }

    @Test
    public void TestIfDeleteOnlyOneOfMultipleIdenticalProductsFromShoppingCartWorks() {
        //Given
        shoppingCart1.addProduct(product1);
        shoppingCart1.addProduct(product1);
        // When
        shoppingCart1.deleteProduct(product1);    // Remove only one occurance of given watch
        //Then
        assertTrue(shoppingCart1.getItems().contains(product1));    // Shoppingcart should still have one of those watches left
    }

    @Test
    public void TestIfRemoveAllOccurrencesOfGivenProductsFromShoppingCartWorks() {
        //Given
        shoppingCart1.addProduct(product1);
        shoppingCart1.addProduct(product1);
        // When
        shoppingCart1.removeAllOccurrencesOfProduct(product1);
        //Then
        List<Product> list = shoppingCart1.getItems();
        boolean foundProduct = false;
        if (!list.isEmpty())     // Empty shoppingCart means no products anyway
        {
            foundProduct = list.contains(product1);
        }
        assertFalse(foundProduct);
    }

    @Test
    public void TestIfShoppingCartIsEmpty() {
        //Given
        shoppingCart1.addProduct(product1);
        shoppingCart1.addProduct(product2);
        shoppingCart1.addProduct(product1);
        // When
        shoppingCart1.clear();
        //Then
        assertTrue(shoppingCart1.getItems().isEmpty());
    }

    @Test
    public void TestIfTotalPriceAfterClearingShoppingCartIsZero() {
        //Given
        shoppingCart1.addProduct(product1);
        shoppingCart1.addProduct(product2);
        shoppingCart1.addProduct(product1);
        // When
        shoppingCart1.clear();   // Resetting ShoppingCart
        //Then
        assertEquals(0.0, shoppingCart1.getTotalPrice());
    }
}
