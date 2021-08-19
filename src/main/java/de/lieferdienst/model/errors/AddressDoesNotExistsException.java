package de.lieferdienst.model.errors;

public class AddressDoesNotExistsException extends Exception{

    private String message;
    public AddressDoesNotExistsException(String message) {
        this.message= message;
    }


    public String getMessage() {
        return message;
    }
}
