package lieferdienst;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Address/////////////////////////
public class Address {

    private String street;
    private String houseNumber;
    private int zipCode;
    private String city;
    ///////////////////////////Constructor//////////////////////////
    public Address(String street,String houseNumber,int zipCode,String city)
    {
        this.street= street;
        this.houseNumber= houseNumber;
        this.zipCode= zipCode;
        this.city= city;
    }
    //////////////////////////////////Getter and setter////////////////////////////
    public String getStreet()                           // Methode getStreet return only the user's Street
    {
        return street;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }
    public String getHouseNumber()                      // Methode getHouseNumber return only the user's HouseNumber
    {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }
    public String getCity()                             // Methode getCity return only the user's City
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public int getZipCode()                             // Methode getZipCode return only the user's ZipCode
    {
        return zipCode;
    }
    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }
    public String viewAddress()                           // Methode to show the Address Details
    {
        String result;
        result =  getStreet()+", "+getHouseNumber()+", "+getZipCode()+", "+getCity();
        return result;
    }
}
/////////////////////////////////////End of class Address/////////////////////////////////
