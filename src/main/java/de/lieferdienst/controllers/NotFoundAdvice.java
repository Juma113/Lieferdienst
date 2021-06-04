package de.lieferdienst.controllers;


import de.lieferdienst.model.errors.NotFounfException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFounfException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(NotFounfException ex) {
        return ex.getMessage();
    }
}
