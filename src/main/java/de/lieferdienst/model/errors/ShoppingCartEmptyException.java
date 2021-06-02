package de.lieferdienst.model.errors;


public class ShoppingCartEmptyException extends Exception{

    private String message;
    public ShoppingCartEmptyException (String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
