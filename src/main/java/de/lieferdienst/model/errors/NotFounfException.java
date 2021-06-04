package de.lieferdienst.model.errors;

public class NotFounfException extends Exception{

    private String message;
    public NotFounfException(String message) {
        this.message= message;
    }


    public String getMessage() {
        return message;
    }
}
