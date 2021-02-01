package lieferdienst;
import org.junit.Test;
import static org.junit.Assert.*;
public class ProductTest {
    // Given
    Product product1 = new Product("productNameTest","productDescriptionTest",
            4.50,"sortTitleTest","restaurantNameTest");
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetProductIdWorks()
    {
        // When
        int result = product1.getProductId();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,7);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetProductNameWorks()
    {
        // When
        String result = product1.getProductName();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"productNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetProductNameWorks()
    {
        // When
        product1.setProductName("newProductNameTest");
        // Then
        assertEquals("Your input is incorrect, check the info below",product1.getProductName(),"newProductNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetProductDescriptionWorks()
    {
        // When
        String result = product1.getProductDescription();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"productDescriptionTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfStProductDescriptionWorks()
    {
        // When
        product1.setProductDescription("newProductDescriptionTest");
        // Then
        assertEquals("Your input is incorrect, check the info below",product1.getProductDescription(),"newProductDescriptionTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetProductPriceWorks()
    {
        // When
        double result = product1.getProductPrice();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,4.50,0);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetProductPriceWorks()
    {
        // When
        product1.setProductPrice(3.50);
        // Then
        assertEquals("Your input is incorrect, check the info below",product1.getProductPrice(),3.50,0);
    }
}