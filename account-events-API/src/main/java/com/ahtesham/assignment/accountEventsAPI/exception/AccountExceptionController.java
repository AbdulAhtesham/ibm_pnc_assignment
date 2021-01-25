package com.ahtesham.assignment.accountEventsAPI.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(annotations = RestController.class)
public class AccountExceptionController {
   
   @ExceptionHandler(value = AccountNumberMissingException.class)
   public ResponseEntity<Object> exception(AccountNumberMissingException exception) {
	      return new ResponseEntity<>("Account number missing in request.", HttpStatus.BAD_REQUEST);
   }
   
   @ExceptionHandler(value = NullPointerException.class)
   public ResponseEntity<Object> exception(NullPointerException exception) {
      return new ResponseEntity<>("Account not found, please recheck the account number.", HttpStatus.NOT_FOUND);
   }
}