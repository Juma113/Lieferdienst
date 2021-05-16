package de.lieferdienst.domains.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

//////////////////////////////////Start Class Customer/////////////////////////
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Customer extends User {

   /* static final AtomicInteger customer_Id = new AtomicInteger(1);
    private int customerId ; // Class Customer add a new Instance variable
    ///////////////////////////Constructor//////////////////////////
    public Customer(String firstName, String lastName, String birthDay,String phoneNumber, String email,String password,String street,String houseNumber,int zipCode,String city)
    {
        super(firstName,lastName,birthDay,phoneNumber,email,password,street,houseNumber,zipCode,city);   // Coll Superclass User
        this.customerId = customer_Id.getAndIncrement();
    }
    //////////////////////////////////Getter////////////////////////////
    public int getCustomerId()             // Methode getCustomerId return only the Customer's Id
    {
        return customerId;
    }

    */
}
/////////////////////////////////////End of class Customer/////////////////////////////////

