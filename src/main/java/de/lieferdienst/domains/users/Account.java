package de.lieferdienst.domains.users;

import de.lieferdienst.domains.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate; ///  import library java.time.LocalDate//////

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class Account/////////////////////////
public class Account extends BaseEntity
{
    private String email;                    // The instance of class account
    private String password;
    private LocalDate created;
    private LocalDate changed;
    /////////////////////////////////Constructor/////////////////////////////////
    public Account(String email,String password)
    {
        this.email=email;
        this.password=password;
        this.created=LocalDate.now() ;
    }
    //////////////////////////////////Getter and setter////////////////////////////
    /*
    public String getEmail()
    {
        return email;           // Methode getEmail return only the user's Email
    }
        public String getPassword()     // Methode getPassword return only the user's Password
    {
        return password;
    }
        public LocalDate getCreated()       // Methode to show Date of the first Account's creation
    {
        return created;
    }
        public LocalDate getChanged()       // Methode to show Date when the User had changed his Password
    {
        return changed;
    }
     */
    public String setEmail(String oldEmail,String newEmail)      // This Methode used to change the Email
    {
        String result = " ";
        if (oldEmail.equals(this.email))
        {
            this.email = newEmail;
            result = this.email;
            return result;
        }
        else
        {
            result = "The entered oldEmail : "+ oldEmail+" is invalid please try again !";
        }

        return result;
    }

    public String setPassword(String oldPassword,String newPassword)       // This Methode used to change the password
    {
        String result = " ";
        if (oldPassword.equals(this.password))
        {
            this.password = newPassword;
            result =this.password;
            this.changed = LocalDate.now();
            return result;
        }
        else
        {
            result = "The entered oldPassword : "+ oldPassword+" is invalid please try again !";
        }
        return result;
    }

}
///
