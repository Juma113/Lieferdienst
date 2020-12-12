package de.MohammadAssaf.lieferdienst;

public class Address {

    private int addressId;
    private String street;
    private String houseNumber;
    private String zipCode ;
    private String city;


    public Address(int addressId,String street,String houseNumber,String zipCode,String city){

        this.addressId=addressId;
        this.street=street;
        this.houseNumber=houseNumber;
        this.zipCode=zipCode;
        this.city=city;

    }

}


