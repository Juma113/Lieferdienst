package de.lieferdienst.model.userManagment;

import de.lieferdienst.model.errors.ShoppingCartEmptyException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.model.orderManagment.Orders;
import de.lieferdienst.model.orderManagment.ShoppingCart;
import de.lieferdienst.model.productManagment.Category;
import de.lieferdienst.model.productManagment.Product;
import de.lieferdienst.model.productManagment.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static de.lieferdienst.model.userManagment.User.get_SHA_256_SecurePassword;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private Address address1;
    private ShoppingCart shoppingCart1;
    private User user1;
    private Restaurant restaurant1;
    private Category category1;
    private Product product1;
    private Orders orders1;



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
        try {
            shoppingCart1.addProduct(product1);
            orders1 = new Orders(address1,shoppingCart1);
        }catch (ShoppingCartEmptyException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfFirstNameWorks(){
        assertEquals("FirstNameTest", user1.getFirstName());
    }

    @Test
    public void testIfLastNameWorks(){
        assertEquals("LastNameTest", user1.getLastName());
    }

    @Test
    public void testIfEmailWorks(){
        assertEquals("usertest@mail.com", user1.getEmail());
    }

    @Test
    public void testIfPhoneWorks(){
        assertEquals("015775651221", user1.getPhone());
    }

    @Test
    public void testIfSecurePasswordWorks(){
        //Given
        String securePassword = get_SHA_256_SecurePassword("passwordTest");

        //Then
        assertEquals("eded82fead402293e0ad6f774aa4cb1d77245c2bc62f3b4c4f3dfcaacb336fe2", securePassword);
    }

    @Test
    public void testIfChangePasswordWorks(){
        //Given
        String password = "testPasswordNew";

        //When
        user1.changePassword(password);

        //Then
        assertEquals("eef62fa520d10e50af49fddfeb72e88b320bcadf97acf1e63efa7ff4eec191c3", user1.getPassword());
    }

    @Test
    public void testIfAddOrdersToOrderListWorks(){
        //Given
        boolean result = user1.addOrder(orders1);

        //Then
        assertTrue(result);
    }

    @Test
    public void testIfRemoveOrderFromOrderListWorks(){
        //Given
        user1.addOrder(orders1);
        boolean result = user1.removeOrder(orders1);
        //Then
        assertTrue(result);
    }


}