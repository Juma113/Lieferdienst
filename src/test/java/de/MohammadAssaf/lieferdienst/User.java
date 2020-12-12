package de.MohammadAssaf.lieferdienst;

import java.util.Scanner;

public class User {

   private int userID;
   private String Password;



   public User (int userID,String password){

       this.userID= userID;
       this.Password= password;
   }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword()
    {
        String password;
        System.out.println("Enter your Password !");
        Scanner scan = new Scanner(System.in);
        password =scan.nextLine();
        if (password.equals(this.Password)){              // Überprüft, ob das Passwort stimmt und lefiert eine entsprechende Nachricht zurück.
             return this.Password;
        }
        else {

            return "The entered password is invalid !";
        }
    }

    public void setPassword() {     // This Function used to change the password .
       System.out.println("To change your Password, please enter the current password");
        String password;
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
        if (password.equals(this.Password)){

            System.out.println("Enter your new Password");
            password = scan.nextLine();
            this.Password = password;
            System.out.println(" your new Password is : "+ this.Password);
        }
        else if(!password.equals(this.Password)){

            System.out.println("The entered password is invalid please try again !");
            password = scan.nextLine();
            if (password.equals(this.Password)){

                System.out.println("Enter a new Password");
                password = scan.nextLine();
                this.Password = password;
                System.out.println(" your new Password is : "+ this.Password);

            }else{

                System.out.println("You have entered an invalid password two times. Your account is blocked");
            }

        }

    }

}
