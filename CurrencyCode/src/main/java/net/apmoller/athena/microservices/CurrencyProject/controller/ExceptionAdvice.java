package net.apmoller.athena.microservices.CurrencyProject.controller;

import net.apmoller.athena.microservices.CurrencyProject.exception.CodeViewException;
import net.apmoller.athena.microservices.CurrencyProject.models.CodeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionAdvice
{
    @ExceptionHandler(CodeViewException.class)
    public ResponseEntity<CodeError> mapException(CodeViewException ex)
    {
        CodeError errorDetails=new CodeError("Invalid","Not found");
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CodeError> mapExceptions(Exception e)
    {
        CodeError error = new CodeError("Kindly check the Details and Enter them correctly", "Your Input is Invalid");
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}