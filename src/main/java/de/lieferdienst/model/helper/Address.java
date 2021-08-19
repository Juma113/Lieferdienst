package de.lieferdienst.model.helper;


import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



//////////////////////////////////Start Class Address/////////////////////////
/**
 * Class which represents an Address
 *
 * @author Lieferdienst Team
 */

@NoArgsConstructor
@Entity
public class Address extends BaseEntity {

    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 35, message = "Street must be 2-35 characters long.")
    private String street;

    @NotNull(message = "House Number cannot be null.")
    @Size(max = 10, message = "House Number must be 1-10 characters long.")
    private String houseNumber;

    @NotNull (message = "zipCode cannot be null.")
    @Size( min = 5 , message = "zipCode must be  5 characters long.")
    private String zipCode;

    @NotNull (message = "City cannot be null.")
    @Size(min = 2, max = 25, message = "City must be 2-25 characters long.")
    private String city;


    ///////////////////////////Constructor//////////////////////////
    /**
     * @param street street
     * @param houseNumber  the house number
     * @param zipCode    the zipcode
     * @param city   the city
     * @author Lieferdienst Team
     */
    public Address(String street, String houseNumber, String zipCode, String city)
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
    public String getZipCode()                             // Methode getZipCode return only the user's ZipCode
    {
        return zipCode;
    }
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                '}';
    }
}
/////////////////////////////////////End of class Address/////////////////////////////////
