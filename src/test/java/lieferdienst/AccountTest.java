package lieferdienst;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AccountTest {
    // Given
    private Account account1 = new Account("emailTest@gmail.com","test12345");
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetEmailWorks()
    {
        // When
        String result = account1.getEmail();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"emailTest@gmail.com");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetEmailWorks()
    {
        // When
        String result =  account1.setEmail("emailTest@gmail.com","newEmailTest@gmail.com");
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"newEmailTest@gmail.com");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetPasswordWorks()
    {
        // When
        String result = account1.getPassword();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"test12345");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetPasswordWorks()
    {
        // When
        String result =  account1.setPassword("test12345","newTest12345");
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"newTest12345");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetCreatedWorks() {
        // When
        LocalDate result = account1.getCreated();
        assertEquals(account1.getCreated(), LocalDate.of(2021,01,31));
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetChangedWorks()
    {
        // When
        LocalDate result = account1.getChanged();
        // Then
        assertEquals(result,null);
    }

}