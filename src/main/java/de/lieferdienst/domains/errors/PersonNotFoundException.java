package de.lieferdienst.domains.errors;

import java.io.Serial;

public class PersonNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = -7366814517715710341L;

    public PersonNotFoundException(String message) {
        super(message);
    }
}
