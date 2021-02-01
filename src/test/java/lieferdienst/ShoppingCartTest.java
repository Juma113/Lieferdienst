package lieferdienst;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    //Given
    ShoppingCart shoppingCart1 = new ShoppingCart();
    @Test
    public void testIfAddNewProductAndWriteShoppingCartWorks()
    {
        // Add Products in the ShoppingCart
        shoppingCart1.addNewProduct("productNameTest1","productDescriptionTest1",
                4.50,"sortTitleTest1","restaurantNameTest1",1);
        shoppingCart1.addNewProduct("productNameTest2","productDescriptionTest2",
                4.50,"sortTitleTest2","restaurantNameTest2",2);
        shoppingCart1.addNewProduct("productNameTest3","productDescriptionTest3",
                4.50,"sortTitleTest3","restaurantNameTest3",3);
        // Print Products from the shoppingCart
        shoppingCart1.writeShoppingCart();
    }

    @Test
    public void testIfFindProductWorks()
    {
        // Add Products in the ShoppingCart
        shoppingCart1.addNewProduct("productNameTest1","productDescriptionTest1",
                4.50,"sortTitleTest1","restaurantNameTest1",1);
        shoppingCart1.addNewProduct("gg","productDescriptionTest2",
                4.50,"sortTitleTest2","restaurantNameTest2",2);
        shoppingCart1.addNewProduct("productNameTest3","productDescriptionTest3",
                4.50,"sortTitleTest3","restaurantNameTest3",3);
        // search Product , which User wants
        shoppingCart1.findProduct("productNameTest");
    }
    @Test
    public void deleteProduct()
    {
        // Add Products in the ShoppingCart
        shoppingCart1.addNewProduct("productNameTest1","productDescriptionTest1",
                4.50,"sortTitleTest1","restaurantNameTest1",1);
        shoppingCart1.addNewProduct("productNameTest2","productDescriptionTest2",
                4.50,"sortTitleTest2","restaurantNameTest2",2);
        shoppingCart1.addNewProduct("productNameTest3","productDescriptionTest3",
                4.50,"sortTitleTest3","restaurantNameTest3",3);
        // Print Products from the shoppingCart
        System.out.println("------------------Before Delete--------------------------");
        shoppingCart1.writeShoppingCart();
        // search Product , which User wants
        shoppingCart1.deleteProduct("productNameTest1");
        System.out.println("------------------After Delete---------------------------");
        // Print Products from the shoppingCart
        shoppingCart1.writeShoppingCart();
    }
}