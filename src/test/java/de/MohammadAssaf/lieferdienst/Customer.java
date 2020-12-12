package de.MohammadAssaf.lieferdienst;

public class Customer extends User {

   private String customerName;
   private String birthDay;
   private String email;
   private long phoneNumber;
   private Address address;



   public Customer(int userID,String password,String customerName,String birthDay,String email,long phoneNumber,Address address){

      super(userID,password);
      this.customerName=customerName;
      this.birthDay=birthDay;
      this.email=email;
      this.phoneNumber=phoneNumber;
      this.address=address;


   }





}
