package de.lieferdienst.model.errors;

import java.io.Serial;

public class UserNotFoundException extends Exception {

    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

