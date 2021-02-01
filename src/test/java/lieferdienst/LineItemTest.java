package lieferdienst;

import org.junit.Test;
import static org.junit.Assert.*;

public class LineItemTest {
    // Given
    LineItem lineItem1 = new LineItem("productNameTest","productDescriptionTest",
            4.50,"sortTitleTest","restaurantNameTest",2);
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetNextElementWorks()
    {
        // When
        LineItem result =  lineItem1.getNextElement();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,null);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetNextElementWorks()
    {
        // Given
        LineItem lineItem2 = new LineItem("productNameTest2","productDescriptionTest2",
                4.50,"sortTitleTest2","restaurantNameTest2",1);
        // When
        lineItem1.setNextElement(lineItem2);
        LineItem result = lineItem2;
        // Then
        assertEquals("Your input is incorrect, check the info below",lineItem1.getNextElement(),result);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetQuantityWorks()
    {
        // When
        int result =  lineItem1.getQuantity();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetQuantityWorks()
    {
        // When
        lineItem1.setQuantity(3);
        // Then
        assertEquals("Your input is incorrect, check the info below",lineItem1.getQuantity(),3);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIFGetQuantityPriceWorks()
    {
        // When
        double result =  lineItem1.getQuantityPrice();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,9.0,0);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetProductWorks()
    {
        // When
        String result1 =  lineItem1.getProduct();
        String result2;
        result2 = "ProductName: productNameTest"+"\n"+"productDescription: productDescriptionTest"
                +"\n"+"ProductPrice: "+"4.5"+"\n"+"categoryTitle: "+"sortTitleTest"
                +"\n"+"RestaurantName: "+"restaurantNameTest";
        // Then
        assertEquals("Your input is incorrect, check the info below",result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void getProductName()
    {
        // When
        String result =  lineItem1.getProductName();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"productNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void viewLineItemProduct()
    {
        // When
        String result1 =  lineItem1.viewLineItemProduct();
        String result2 = "ProductName: productNameTest"+"\n"+"productDescription: productDescriptionTest"
                +"\n"+"ProductPrice: "+"4.5"+"\n"+"categoryTitle: "+"sortTitleTest"
                +"\n"+"RestaurantName: "+"restaurantNameTest"+"\n"+"Quantity: "+"2"+"\n"+"Price: "+"9.0"+" €";
        // Then
        assertEquals("Your input is incorrect, check the info below",result1,result2);
    }
}