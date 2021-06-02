package de.lieferdienst.model.errors;


public class AddressExistsException extends Exception{

    private String message;
    public AddressExistsException(String message)
    {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
