package lieferdienst;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class User/////////////////////////
public class User {

    private String firstName;
    private String lastName;
    private String birthDay;
    private String phoneNumber;
    private Address address;
    private Account account;
    ///////////////////////////Constructor//////////////////////////
    public User (String firstName, String lastName, String birthDay,String phoneNumber, String email,String password,String street,String houseNumber,int zipCode,String city)
    {
        this.firstName= firstName;
        this.lastName= lastName;
        this.birthDay= birthDay;
        this.phoneNumber= phoneNumber;
        account= new Account(email,password);
        address = new Address(street,houseNumber,zipCode,city);
    }
    //////////////////////////////////Getter and setter////////////////////////////
    public String getFirstName()                    // Methode getFirstName return only the user's FirstName
    {
        return firstName;
    }
    public void setFirstName(String firstName)      // This Methode used to change the Firstname
    {
        this.firstName = firstName;
    }
    public String getLastName()                     // Methode getLastName return only the user's LastName
    {
        return lastName;
    }
    public void setLastName(String lastName)        // This Methode used to change the Lastname
    {
        this.lastName = lastName;
    }
    public String getBirthDay()                     // Methode getBirthDay return only the user's LastName
    {
        return birthDay;
    }
    public void setBirthDay(String birthDay)        // This Methode used to change the Birthday
    {
        this.birthDay = birthDay;
    }
    public String getPhoneNumber()                  // Methode getPhoneNumber return only the user's PhoneNumber
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)  // This Methode used to change the PhoneNumber
    {
        this.phoneNumber = phoneNumber;
    }
    public String getAccount()                     // Methode to show the Account Details
    {
      String result = account.getEmail()+", "+account.getPassword();
      return result;
    }
    public void setAccount(Account account)         // Methode to change the Account Details
    {
        this.account = account;
    }
    public String getAddress()                        // Methode to show the Address Details
    {
        return this.address.viewAddress();
    }
    public void setAddress(Address address)        // Methode to change the Address Details
    {
        this.address = address;
    }
    public String viewUser()                         // Methode to show the User's Details
    {
        String result;
        result="firstName: "+getFirstName()+"\n"+"lastName: "+getLastName()
                +"\n"+"birthDay: "+getBirthDay()+"\n"+"phoneNumber: "+getPhoneNumber()+
                "\n"+"Address: "+getAddress();
        return result;
    }
}
/////////////////////////////////////End of class User/////////////////////////////////
