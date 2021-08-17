package de.lieferdienst.model.orderManagmant;

import de.lieferdienst.model.orderManagment.Payment;
import de.lieferdienst.model.orderManagment.PaymentMethod;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Date;

public class PaymentTest {

    private Date paid = new Date();
    private PaymentMethod creditcard = PaymentMethod.CREDITCARD;
    private String details = "TestDetails";

    @Test
    public void TestIfPaymentWithGivenMethodWorks()
    {
        //Given
        Payment payment = new Payment(creditcard, details);
        // When

        //Then
        assertEquals(PaymentMethod.CREDITCARD, payment.getPaymentMethod());
    }

    @Test
    public void TestIfPaymentWithGivenDetailsWorks()
    {
        //Given
        Payment payment = new Payment(creditcard, details);
        // When

        //Then
        assertEquals(details, payment.getDetails());
    }

    @Test
    public void TestIfPaymentWithDatePaidWorks()
    {
        //Given
        Payment payment = new Payment(paid, creditcard, details);
        // When

        //Then
        assertEquals(paid, payment.getDatePaid());
    }
}
