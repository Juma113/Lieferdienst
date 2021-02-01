package lieferdienst;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {
    // Given
    Payment object1 = new Payment();
    PayPal paypalObject1 = new PayPal("payPalTest@gmail.com", "test1234");
    CreditCard creditCardObject1 = new CreditCard("cardHolderNameTest","4051658462349478","11/23",148);
    DepitCard depitCardObject1 = new DepitCard("bankNameTest","cardHolderNameTest","DE45845210004612182465","HELADEF2WEM");
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfAddCreditCardWorks()
    {
        // When
        CreditCard result =  object1.AddCreditCard(creditCardObject1);
        CreditCard result1 = creditCardObject1;
        // Then
        assertEquals(result,result1);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfAddDepitCardWorks()
    {
        // When
        DepitCard result =  object1.AddDepitCard(depitCardObject1);
        DepitCard result1 = depitCardObject1;
        // Then
        assertEquals(result,result1);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfaAddPayPalWorks()
    {
        // When
        PayPal result =  object1.AddPayPal(paypalObject1);
        PayPal result1 = paypalObject1;
        // Then
        assertEquals(result,result1);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfRemoveCreditCardWorks()
    {
        object1.AddCreditCard(creditCardObject1);
        // When
        CreditCard result1 =  object1.removeCreditCard(creditCardObject1);
        CreditCard result2 = creditCardObject1;
        // Then
        assertEquals(result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfRemoveDepitCardWorks()
    {
        // Given
        object1.AddDepitCard(depitCardObject1);
        // When
        DepitCard result1 = object1.removeDepitCard(depitCardObject1);
        DepitCard result2 = depitCardObject1;
        // Then
        assertEquals(result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfRemovePayPalWorks()
    {
        // Given
        object1.AddPayPal(paypalObject1);
        // When
        PayPal result1 = object1.removePayPal(paypalObject1);
        PayPal result2 = paypalObject1;
        // Then
        assertEquals(result1,result2);
    }
}
