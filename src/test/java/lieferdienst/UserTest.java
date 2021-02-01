package lieferdienst;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    // Given
    User user1 = new User("firstNameTest","lastNameTest","2021-02-01",
            "015449591334","emailTest@gmail.com","passTest11",
            "streetTest","5a",99089,"cityTest");
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetFirstNameWorks()
    {
        // When
        String result = user1.getFirstName();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"firstNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetFirstNameWorks()
    {
        // When
         user1.setFirstName("newFirstNameTest");
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getFirstName(),"newFirstNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIFGetLastNameWorks()
    {
        // When
        String result = user1.getLastName();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"lastNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetLastNameWorks()
    {
        // When
        user1.setLastName("newLastNameTest");
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getLastName(),"newLastNameTest");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetBirthDayWorks()
    {
        // When
        String result = user1.getBirthDay();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"2021-02-01");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetBirthDayWorks()
    {
        // When
        user1.setBirthDay("13-07-1995");
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getBirthDay(),"13-07-1995");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetPhoneNumberWorks()
    {
        // When
        String result = user1.getPhoneNumber();
        // Then
        assertEquals("Your input is incorrect, check the info below",result,"015449591334");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetPhoneNumberWorks()
    {
        // When
        user1.setPhoneNumber("014119291664");
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getPhoneNumber(),"014119291664");
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetAccountWorks()
    {
        // When
        String result1 = user1.getAccount();
        String result2 = "emailTest@gmail.com, passTest11";
        // Then
        assertEquals("Your input is incorrect, check the info below",result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetAccountWorks()
    {   // Given
            Account accountTest = new Account("newEmailTest@gmail.com","newPassTest11");
        // When
        user1.setAccount(accountTest);
        String result = "newEmailTest@gmail.com, newPassTest11";
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getAccount(),result);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfGetAddressWorks()
    {
        // When
        String result1 = user1.getAddress();
        String result2 = "streetTest, 5a, 99089, cityTest";
        // Then
        assertEquals("Your input is incorrect, check the info below",result1,result2);
    }
    //----------------------------------------------------------------------------------------------------------//
    @Test
    public void testIfSetAddressWorks()
    {   // Given
         Address addressTest = new Address("newStreetTest","3a",98099,"newCityTest");
        // When
        user1.setAddress(addressTest);
        String result = "newStreetTest, 3a, 98099, newCityTest";
        // Then
        assertEquals("Your input is incorrect, check the info below",user1.getAddress(),result);
    }
}