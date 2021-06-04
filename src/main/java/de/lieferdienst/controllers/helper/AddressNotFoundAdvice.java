package de.lieferdienst.controllers.helper;

import de.lieferdienst.model.errors.AddressDoesNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddressNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AddressDoesNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(AddressDoesNotExistsException ex) {
        return ex.getMessage();
    }
}
