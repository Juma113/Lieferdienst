package de.lieferdienst.model.errors;

public class OrderNotFounfException extends Exception{

    private String message;
    public OrderNotFounfException(String message) {
        this.message= message;
    }


    public String getMessage() {
        return message;
    }
}
