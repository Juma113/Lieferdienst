package lieferdienst;
import java.util.concurrent.atomic.AtomicInteger;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Employee/////////////////////////
public class Employee extends User{

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
}
/////////////////////////////////////End of class Employee/////////////////////////////////
