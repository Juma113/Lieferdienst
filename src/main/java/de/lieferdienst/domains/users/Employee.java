package de.lieferdienst.domains.users;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

//////////////////////////////////Start Class Employee/////////////////////////
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee extends User {

   /*
    static final AtomicInteger employee_Id = new AtomicInteger(1);
    private int employeeId; // Class Employee add a new Instance variable
    ///////////////////////////Constructor//////////////////////////
    public Employee(String firstName, String lastName, String birthDay,String phoneNumber, String email,String password,String street,String houseNumber,int zipCode,String city)
    {
        super(firstName,lastName,birthDay,phoneNumber,email,password,street,houseNumber,zipCode,city);      // Coll Superclass User
        this.employeeId= employee_Id.getAndIncrement();
    }
    //////////////////////////////////Getter////////////////////////////
    public int getEmployeeId()          // Methode getEmployeeId return only the Employee's Id
    {
        return employeeId;
    }

    */
}
/////////////////////////////////////End of class Employee/////////////////////////////////
