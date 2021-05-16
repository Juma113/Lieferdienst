package de.lieferdienst.domains.users;

import de.lieferdienst.domains.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class User/////////////////////////
public class User extends BaseEntity implements Comparable<User> {

    private String firstName;
    private String lastName;
    private String birthDay;
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Account account;
    /////////////////////////////////////////////////////

    public String viewUser()                         // Methode to show the User's Details
    {
        String result;
        result="firstName: "+getFirstName()+"\n"+"lastName: "+getLastName()
                +"\n"+"birthDay: "+getBirthDay()+"\n"+"phoneNumber: "+getPhoneNumber()+
                "\n"+"Address: "+getAddress();
        return result;
    }

    @Override
    public int compareTo(final User user) {
        return this.lastName.compareTo(user.getLastName());
    }
}
/////////////////////////////////////End of class User/////////////////////////////////
