package lieferdienst;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.junit.Assert.*;
public class OrdersTest {
    //Given
    Customer customer1 = new Customer("firstNameTest","lastNameTest","2021-02-01",
            "015449591334","emailTest@gmail.com","passTest11",
            "streetTest","5a",99089,"cityTest");
    LineItem pro1 = new LineItem("productNameTest1","productDescriptionTest1",
            4.50,"sortTitleTest1","restaurantNameTest1",1);
    LineItem pro2 = new LineItem("productNameTest2","productDescriptionTest2",
            2.50,"sortTitleTest2","restaurantNameTest2",2);
    LineItem pro3 = new LineItem("productNameTest3","productDescriptionTest3",
            1.50,"sortTitleTest3","restaurantNameTest3",3);
    LineItem pro4 = new LineItem("productNameTest4","productDescriptionTest4",
            3.50,"sortTitleTest4","restaurantNameTest4",1);
    ArrayList<LineItem> orderList = new ArrayList<LineItem>();
    Orders order1 = new Orders(customer1,orderList);
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetOrderDateWorks()
    {
        // When
        LocalDate result = order1.getOrderDate();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,LocalDate.now());
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetOrderIdWorks()
    {
        // When
        int result = order1.getOrderId();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,3);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetCustomerWorks()
    {
        // When
        String result1 = order1.getCustomer();
        String result2 = "firstName: "+"firstNameTest"+"\n"+"lastName: "+"lastNameTest"
                +"\n"+"birthDay: "+"2021-02-01"+"\n"+"phoneNumber: "+"015449591334"+
                "\n"+"Address: "+"streetTest, 5a, 99089, cityTest";
        // Then
        assertEquals("Your input is incorrect, check the info below",result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetOrderListWorks()
    {
        // When
        orderList.add(pro1);
        orderList.add(pro2);
        orderList.add(pro3);
        orderList.add(pro4);
        order1.getOrderList();
        // Then
        assertEquals(orderList.size(),4);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetOrderListWorks()
    {
        orderList.add(pro1);
        orderList.add(pro2);
        orderList.add(pro3);
        orderList.add(pro4);
        order1.getOrderList();
        // When
        ArrayList<LineItem> orderList2 = new ArrayList<LineItem>();
        orderList2.add(pro1);
        orderList2.add(pro2);
        order1.setOrderList(orderList2);
        // Then
        assertEquals(order1.getOrderList().size(),2);
    }
}